package Fotos;

public class Auxiliar {
    public Usuario user;
    public Postagem post;

    public int comparador(Auxiliar o1, Auxiliar o2) {
        int data = o2.post.getD().compara(o1.post.getD());
        if (data != 0) return data;
        else {
            int seguidor = o2.user.comp_seguidores(o1.user.seguidores);
            if (seguidor != 0) return seguidor;
            else {
                return o1.user.comp_login(o2.user.login);
            }
        }
    }
}
