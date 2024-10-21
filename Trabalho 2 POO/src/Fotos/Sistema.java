package Fotos;

import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Objects;

public class Sistema {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private ArrayList<Empresa> empresas = new ArrayList<>();

    public Usuario buscarUsuario(String login) {
        for (Usuario u : this.pessoas) {
            if (Objects.equals(u.login, login)) return u;
        }
        for (Usuario u : this.empresas) {
            if (Objects.equals(u.login, login)) return u;
        }

        return null;
    }

    public void novaPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    public void novaEmpresa(Empresa e) {
        this.empresas.add(e);
    }

    public void listarUsuarios() {
        System.out.println("Pessoas:");
        for (Usuario u : this.pessoas) {
            System.out.println(u.toString());
        }
        System.out.println("Empresas: ");
        for (Usuario u : this.empresas) {
            System.out.println(u.toString());
        }
    }

    public void CarregarDados() throws IOException {
        try {
            String arq = "dados.txt";
            FileReader f = new FileReader(arq);
            BufferedReader buff = new BufferedReader(f);
            String letra = buff.readLine();
            while (!Objects.equals(letra, "F")) {
                if (Objects.equals(letra, "P")) {
                    String login = buff.readLine();
                    String nome = buff.readLine();
                    String senha = buff.readLine();
                    String cpf = buff.readLine();
                    int dia = Integer.parseInt(buff.readLine());
                    int mes = Integer.parseInt(buff.readLine());
                    int ano = Integer.parseInt(buff.readLine());
                    Pessoa p = new Pessoa(login, nome, senha, cpf, dia, mes, ano);
                    this.novaPessoa(p);
                }
                if (Objects.equals(letra, "E")) {
                    String login = buff.readLine();
                    String nome = buff.readLine();
                    String senha = buff.readLine();
                    String cnpj = buff.readLine();
                    Empresa e = new Empresa(login, nome, senha, cnpj);
                    this.novaEmpresa(e);
                }
                if (Objects.equals(letra, "S")) {
                    String seguidor = buff.readLine();
                    String seguindo = buff.readLine();
                    Usuario u1 = this.buscarUsuario(seguidor);
                    Usuario u2 = this.buscarUsuario(seguindo);
                    u1.seguir(u2, this);
                }

                letra = buff.readLine();
            }
            buff.close();
        } catch (FileNotFoundException e) {

        }
    }

    public void SalvarDados() throws IOException {
        String arq = "dados.txt";

        FileWriter f = new FileWriter(arq);
        BufferedWriter buff = new BufferedWriter(f);


        for (Pessoa p : this.pessoas) {
            buff.write("P\n");
            buff.write(p.login + "\n");
            buff.write(p.nome + "\n");
            buff.write(p.senha + "\n");
            buff.write(p.getCpf() + "\n");
            buff.write(p.getNasc().getDia() + "\n");
            buff.write(p.getNasc().getMes() + "\n");
            buff.write(p.getNasc().getAno() + "\n");
        }
        for (Empresa e : this.empresas) {
            buff.write("E\n");
            buff.write(e.login + "\n");
            buff.write(e.nome + "\n");
            buff.write(e.senha + "\n");
            buff.write(e.getCnpj() + "\n");
        }
        for (Pessoa p : this.pessoas) {
            for (Usuario u : p.seguindo) {
                buff.write("S\n");
                buff.write(p.login + "\n");
                buff.write(u.login + "\n");
            }
        }
        for (Empresa e : this.empresas) {
            for (Usuario u : e.seguindo) {
                buff.write("S\n");
                buff.write(e.login + "\n");
                buff.write(u.login + "\n");
            }
        }
        buff.write("F");
        buff.close();
    }
}
