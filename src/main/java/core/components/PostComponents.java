package core.components;

import core.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("core.components.PostComponents")
public class PostComponents {
    public List<Post> getPost() {
        ArrayList<Post> posts = new ArrayList<Post>();
        posts.add(new Post(1, "Descubre las últimas tendencias en desarrollo web que están dando forma al futuro de la industria. Desde AR y VR hasta lenguajes de programación emergentes, este post te mantendrá actualizado.", "http://localhost:8080/img/card.jpeg", new Date(), "Las Tendencias del Desarrollo Web en 2024"));
        posts.add(new Post(2, "La experiencia del usuario es clave. Aprende estrategias y consejos para mejorar la usabilidad y la retención de usuarios en tu sitio web.", "http://localhost:8080/img/card.jpeg", new Date(), "Cómo Optimizar tu Sitio Web para la Experiencia del Usuario"));
        posts.add(new Post(3, "Descubre las últimas tácticas y mejores prácticas para proteger tu sitio web contra amenazas cibernéticas. Mantén tus datos y los de tus usuarios seguros.", "http://localhost:8080/img/card.jpeg", new Date(), "Seguridad en el Desarrollo Web: Protegiendo tu Sitio de las Amenazas Actuales"));
        posts.add(new Post(4, "Las PWAs están cambiando la forma en que interactuamos con las aplicaciones web. Explora su historia, características y su impacto en el desarrollo web moderno.", "http://localhost:8080/img/card.jpeg", new Date(), "Evolución de las Aplicaciones Web Progresivas (PWA)"));
        return posts;
    }
}
