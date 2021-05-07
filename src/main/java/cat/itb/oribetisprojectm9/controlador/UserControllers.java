package cat.itb.oribetisprojectm9.controlador;
import cat.itb.oribetisprojectm9.model.entitats.User;
import cat.itb.oribetisprojectm9.model.serveis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControllers {
    @Autowired
    private UserService servei;

    @GetMapping("/registre")
    public String registre(Model m){
        m.addAttribute("usuariForm",new User());
        return "registre";
    }

    @PostMapping("/registre")
    public String registrarUsuari(@ModelAttribute User usu) throws Exception{
        servei.registrar(usu);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/secret")
    public String root(){
        return "secret";
    }



}
