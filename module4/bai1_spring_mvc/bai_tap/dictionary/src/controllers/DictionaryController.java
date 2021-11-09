package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    static Map<String, String> dictionary = new HashMap();

    static {
        dictionary.put("face", "Khuôn mặt");
        dictionary.put("mouth", "Miệng");
        dictionary.put("chin", "Cằm");
        dictionary.put("neck", "Cổ");
        dictionary.put("shoulder", "Vai");
        dictionary.put("chest", "Ngực");
        dictionary.put("buttocks", "Mông");
        dictionary.put("thigh", "Bắp đùi");
        dictionary.put("knee", "Đầu gối");
    }

    @GetMapping(value = "/search")
    public ModelAndView viewSearch() {
        return new ModelAndView("dictionary");
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam String word, Model model) {
        String english = word.trim().toLowerCase();
        String vietnamese = dictionary.get(english);
        model.addAttribute("english", english);
        if (vietnamese != null) {
            model.addAttribute("vietnamese", vietnamese);
        } else {
            model.addAttribute("vietnamese", "Không tìm thấy");
        }
        return "dictionary";
    }
}
