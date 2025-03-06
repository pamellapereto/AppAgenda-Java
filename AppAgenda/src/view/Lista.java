package view;
import model.ListaDAO;

import java.util.Scanner;

public class Lista {
    static Scanner scanner = new Scanner(System.in);
    static ListaDAO listaDAO = new ListaDAO();

    public static void main (String[] args) {
        inputLista();
    }

    private static void inputLista() {
        System.out.println("-----NOVA LISTA-----");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        //Validar o campo para verificar se ele está vazio.
        if (nome.isEmpty()) {
            System.out.println("Campo nome obrigatório");
        }
        else {
            controller.Lista lista = new controller.Lista(nome);
            boolean sucesso = listaDAO.inserirLista(lista);
            if (sucesso) {
                lista.cadastroSucesso();
            } else {
                lista.cadastroErro();
            }
        }
    }

    private static void updateLista() {
        System.out.println("-----ATUALIZAR LISTA-----");
        System.out.println("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Nome: ");
        String nome = scanner.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("Campo obrigatório");
        }
        else {
            listaDAO.atualizarLista(id, nome);
        }
    }
}




