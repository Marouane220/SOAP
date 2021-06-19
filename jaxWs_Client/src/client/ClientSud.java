package client;

import java.rmi.RemoteException;

import sud.webservices.Product;
import sud.webservices.ProductsManagerImplProxy;

public class ClientSud {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		ProductsManagerImplProxy proxy = new ProductsManagerImplProxy();
		Product produit1 = new Product(1, "Eggs", 2 ); 
		Product produit2 = new Product(2, "Water", 5 ); 
		Product produit3 = new Product(3, "Candy", 10 ); 
		Product produit4 = new Product(4, "Bred", 3);
		// Ajout des produits		
		proxy.addProduct(produit1);
		proxy.addProduct(produit2);
		proxy.addProduct(produit3);
		proxy.addProduct(produit4);
		System.out.println("******** Le 1er produit ********");
		System.out.println("----- Id: "+proxy.getProduct(1).getId());
		System.out.println("----- Label: "+proxy.getProduct(1).getLabel());
		System.out.println("----- Price: "+proxy.getProduct(1).getPrice()+"Dh");
		System.out.println("**********************************************************");
		System.out.println("******** Liste des produits ********");
		for(int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("-- Le produits "+i+":");
			System.out.println("------- Id: "+proxy.getProducts()[i].getId());
			System.out.println("------- Label: "+proxy.getProducts()[i].getLabel());
			System.out.println("------- Price: "+proxy.getProducts()[i].getPrice()+"Dh");
		}
		// modifier le 2eme produit
		System.out.println("**********************************************************");
		System.out.println("******** Suppression du 2eme produit ******** \n");
		proxy.deleteProduct(2);
		System.out.println("Produit supprimer avec succes");
		//liste des produits apres la suppression
		System.out.println("**********************************************************");
		System.out.println("******** Liste des produits apres la suppression ********");
		for(int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("-- Le produits "+i+":");
			System.out.println("------- Id: "+proxy.getProducts()[i].getId());
			System.out.println("------- Label: "+proxy.getProducts()[i].getLabel());
			System.out.println("------- Price: "+proxy.getProducts()[i].getPrice()+"Dh");
		}
		// Supprimer tous les produits
		System.out.println("**********************************************************");
		System.out.println("******** Suppression de tous les produits ******** \n");
		proxy.deleteAllProducts();
		System.out.println("Produits sont supprimer avec succes \n");
	}

}
