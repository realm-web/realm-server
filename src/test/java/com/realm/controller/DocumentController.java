import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annoation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "https://localhost:5173")
@RestController
@RequestMapping("/documents")
public class DocumentController {
    private DocumentService DocumentService

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/{id}")
    public Mono<ResponseEntity<Void>> addDocument(
        @PathVariable Long id,
        @RequestBody CreateDocumentRequest request,
        UriComponentsBuilder uriComponentsBuilder) {
            
        }
}