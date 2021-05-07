package cat.itb.oribetisprojectm9.model.serveis;

import cat.itb.oribetisprojectm9.model.entitats.Dino;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DinoService {
    private List<Dino> repositori = new ArrayList<>();
    public void afegir(Dino d) {
        repositori.add(d);
    }
    public List<Dino> dinoList() {
        return repositori;
    }



    public void deleteById(int id){
        for(int i=0; i<repositori.size();i++){
            if (repositori.get(i).getId()==id) {
                repositori.remove(i);
            }
        }
    }
    public void edit(Dino e){
        for(int i=0;i<repositori.size();i++){
            if(repositori.get(i).getId()==e.getId()){
                repositori.set(i,e);
            }
        }
    }

    public Dino findDinoById(int id){
        Dino d = null;
        for (int i=0;i<repositori.size();i++){
            if (repositori.get(i).getId()==id){
                d = repositori.get(i);
            }
        }
        return d;
    }




    @PostConstruct
    public void afegirInici() {
        repositori.add(new Dino(42, "Titanoboa", "Medium", "2000", "Carnivorous"));
        repositori.add(new Dino(56, "Therizinosaurus", "Medium", "5000", "Omnivore"));
        repositori.add(new Dino(311, "Titanosaur", "Low", "13000", "Herbivorous"));
    }
}

