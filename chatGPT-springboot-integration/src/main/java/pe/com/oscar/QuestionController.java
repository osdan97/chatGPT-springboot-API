package pe.com.oscar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.oscar.dto.ResponseDTO;

@Slf4j
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

	private final ChatgptService chatgptService;
	
	@PostMapping("/send")
    public ResponseDTO<String> send(@RequestBody String message){
        log.info("message is: {}", message);
        String responseMessage = chatgptService.sendMessage(message);
        log.info("response is: {}", responseMessage);

        return ResponseDTO.success(responseMessage);
    }
	@GetMapping("/prueba")
	public String prueba() {
		return "Funciona el rest";
	}
	
}
