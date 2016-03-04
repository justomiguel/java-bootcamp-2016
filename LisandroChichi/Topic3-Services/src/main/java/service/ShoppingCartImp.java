package service;

import java.util.ArrayList;

import product.Product;

public class ShoppingCartImp implements ShoppingCartService {

	ArrayList<Product> listProducts = new ArrayList<Product>();

	public Boolean addProduct(Product product) {
		int cont = 0;
		for (int i = 0; i < listProducts.size(); i++) {
			if (listProducts.get(i).getName() == product.getName()) {
				listProducts.get(i).setQty(
						listProducts.get(i).getQty() + product.getQty());
				cont++;
			}
		}
		if (cont == 0) {
			listProducts.add(product);
			return true;
		}
		return true;
	}

	public Boolean deleteProduct(String name, int qty) {
		try{
		for (int i = 0; i < listProducts.size(); i++) {
			if (listProducts.get(i).getName().equals(name)) {
				listProducts.get(i).setQty(listProducts.get(i).getQty() - qty);
				if (listProducts.get(i).getQty() < 0) {
					listProducts.get(i).setQty(0);
				}
				return true;
			}
		}
		}catch(Exception e){
			System.out.println("no existe dato para eliminar");
		}
		return false;
	}

	public Product searchProducts(String name) {
		Product seach = null;
		for (int i = 0; i < listProducts.size(); i++) {
			if (listProducts.get(i).getName() == name) {
				System.out.println("Nombre: " + listProducts.get(i).getName()
						+ " Precio: " + listProducts.get(i).getPrice());
				return listProducts.get(i);
			}
		}
		return seach;

	}

	public void updateProduct(String oldName, String newName, double price) {
		try {
			for (int i = 0; i < listProducts.size(); i++) {
				if (listProducts.get(i).getName() == oldName) {
					listProducts.get(i).setName(newName);
					listProducts.get(i).setPrice(price);
				}
			}
		} catch (Exception e) {
			System.out.println("error al ingresar los datos");
		}

	}

	public double calculatePrice() {
		double total = 0;
		for (int i = 0; i < listProducts.size(); i++) {
			total += listProducts.get(i).getPrice()
					* listProducts.get(i).getQty();
		}
		return total;
	}

}