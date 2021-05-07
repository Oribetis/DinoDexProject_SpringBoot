  package cat.itb.oribetisprojectm9.controlador;


import cat.itb.oribetisprojectm9.model.entitats.Dino;
import cat.itb.oribetisprojectm9.model.serveis.DinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DinosController {
    @Autowired
    private DinoService servei;


    @GetMapping("/dinos/list")
    public String listDinos(Model m){
        m.addAttribute("dinosList",servei.dinoList());
        return "llistat";
    }

    @GetMapping("/dinos/new")
    public String addDino(Model m){

        m.addAttribute("dinoForm",new Dino());
        return "afegir";
    }

    @GetMapping("/dinos/edit/{id}")
    public String editDino(@PathVariable(value="id") int id, Model m){
        m.addAttribute("dinoForm", servei.findDinoById(id));
        return "afegir";
    }

    @PostMapping("dinos/new/submit")
    public String submitDino(@ModelAttribute("dinoForm") Dino dino){
        servei.afegir(dino);
        return "redirect:/dinos/list";
    }

    @GetMapping("/dinos/eliminar/{id}")
    public String deleteDino(@PathVariable(value="id") int id){
        servei.deleteById(id);
        return "redirect:/dinos/list";
    }

    @PostMapping("/dinos/edit/submit")
    public String editDino(@ModelAttribute("dinoForm") Dino emp){
        servei.edit(emp);
        return "redirect:/dinos/list";
    }
}
