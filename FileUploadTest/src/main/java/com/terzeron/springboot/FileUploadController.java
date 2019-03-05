package com.terzeron.springboot;

import com.terzeron.springboot.storage.StorageFileNotFoundException;
import com.terzeron.springboot.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

/**
 * Created by terzeron on 2017. 1. 9..
 */
@Controller
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    // 저장소로부터 업로드된 파일 리스트를 가져다가 thymeleaf 템플릿에 전달하여 렌더링
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws Exception {
        model.addAttribute("files", storageService
                .loadAll()
                .map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                        .build()
                        .toString())
                .collect(Collectors.toList()));
        return "uploadForm";
    }

    // 리소스를 가져다가 Content-Disposition 헤더를 가지고 브라우저가 다운로드할 수 있도록 함
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    // 멀티파트 파일을 전송하여 저장소에 저장하도록 함
    @PostMapping("/")
    public String handleFielUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
