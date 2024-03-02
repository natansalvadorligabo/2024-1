package view;

import java.util.Scanner;
import controller.ProductController;
import dto.ProductDto;

public class Console {

    private ProductController productController;
    Scanner scanner = new Scanner(System.in);

    public Console() {
        productController = new ProductController();
    }

    public void run() {
        int option;
        do {
            menu();

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    listProducts();
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

    private void menu() {
        System.out.println("\n[1] - Adicionar Produto");
        System.out.println("[2] - Remover Produto");
        System.out.println("[3] - Atualizar Produto");
        System.out.println("[4] - Listar Produtos");
        System.out.println("[0] - Sair");
        System.out.print("Escolha sua opção: ");
    }

    private void addProduct() {
        System.out.print("Nome do produto: ");
        String name = scanner.nextLine();

        System.out.print("Descrição do produto: ");
        String description = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double price = scanner.nextDouble();

        System.out.print("Quantidade em estoque: ");
        int stockQuantity = scanner.nextInt();

        ProductDto newProduct = new ProductDto(name, description, price, stockQuantity);

        if (productController.add(newProduct)) {
            System.out.println("Produto adicionado com sucesso!");
        } else {
            System.out.println("Não foi possível adicionar o produto.");
        }
    }

    private void removeProduct() {
        System.out.print("Digite o ID do produto a ser removido: ");
        int productId = scanner.nextInt();

        if (productController.delete(productId)) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void updateProduct() {
        listProducts();

        System.out.print("Digite o ID do produto a ser atualizado: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        if (productController.findById(productId)) {
            System.out.print("Novo nome do produto: ");
            String newName = scanner.nextLine();

            System.out.print("Nova descrição do produto: ");
            String newDescription = scanner.nextLine();

            System.out.print("Novo preço do produto: ");
            double newPrice = scanner.nextDouble();

            System.out.print("Nova quantidade em estoque: ");
            int newStockQuantity = scanner.nextInt();

            ProductDto updatedProduct = new ProductDto(newName, newDescription, newPrice, newStockQuantity);
            
            if (productController.update(productId, updatedProduct)) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Não foi possível atualizar o produto.");
            }
        } else {
            System.out.println("Produto não encontrado. Não é possível atualizar.");
        }
    }

    private void listProducts() {
        System.out.println("\nPRODUTOS:");

        if (productController.getAllProducts().isEmpty()) {
            System.out.println("Não há produtos adicionados.");
        } else {
            for (ProductDto product : productController.getAllProducts()) {
                System.out.printf(
                        "\tProduto %d: %s\n\tDescrição: %s\n\tPreço: R$ %.2f\n\tQuantidade em estoque: %d unidades\n\n",
                        product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                        product.getStockQuantity());
            }
        }
    }
}
