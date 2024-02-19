package br.edu.ifsp.arq.tsi.deoo.view;

import br.edu.ifsp.arq.tsi.deoo.dao.UserDao;
import br.edu.ifsp.arq.tsi.deoo.dao.UserDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.model.User;

import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserDao userDao = UserDaoImpl.getInstance();

    public static void main(String[] args) throws Exception {
        int option;

        do {
            menu();

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    recoverPassword();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.err.println("Opção inválida.");
                    break;
            }

        } while (option != 0);
    }

    private static void login() {
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        if (userDao.login(username, password)) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.err.println("Login falhou. Verifique o nome de usuário ou a senha.");
        }
    }

    private static void register() {
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        User newUser = new User(username, email, password);

        if (userDao.insertUser(newUser)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.err.println("Erro ao registrar usuário. Tente novamente!");
        }
    }

    private static void recoverPassword() {
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
    
        User user = userDao.findByUsername(username);
    
        if (user != null) {
            if (user.getEmail().equals(email)) {
                System.out.printf("Informe uma nova senha:");
                String newPassword = scanner.nextLine();
                
                user.setPassword(newPassword);
                userDao.updateUser(user);
                
                System.out.println("Senha alterada com sucesso.");
            } else {
                System.err.println("Recuperação de senha falhou. Verifique as informações!");
            }
        } else {
            System.err.println("Usuário não cadastrado.");
        }
    }

    private static void menu() {
        System.out.println("\n[1] - Login");
        System.out.println("[2] - Cadastrar");
        System.out.println("[3] - Esqueci minha senha");
        System.out.println("[0] - Sair");
        System.out.print("Escolha sua opção: ");
    }
}
