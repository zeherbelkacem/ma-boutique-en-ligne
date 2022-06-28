package com.fms.springEx1;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Entities.Category;
import com.fms.springEx1.Entities.Order;
import com.fms.springEx1.Security.RoleService;
import com.fms.springEx1.Security.Rrole;
import com.fms.springEx1.Security.Rrole;
import com.fms.springEx1.Security.UserService;
import com.fms.springEx1.Security.Uuser;
import com.fms.springEx1.Service.IArticleService;
import com.fms.springEx1.Service.ICategoryService;
import com.fms.springEx1.Service.OrderService;

@SpringBootApplication
public class SpringEx1Application implements CommandLineRunner {

	/*
	 * Scanner
	 */
	private static Scanner scanner = new Scanner(System.in);

	private String login = null;

	private long idUser = 0;

	/*
	 * Repositories Dependency Injections
	 */
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrderService orderService;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	@Autowired
//	private OrderItemService orderItemService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEx1Application.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * 
		 */

//		roleService.saveRole(new Rrole(0, "ADMIN"));
//		roleService.saveRole(new Rrole(0, "USER"));
//		userService.saveUuser(new Uuser(0, "belkacem", passwordEncoder.encode("1234"), true));
//		userService.saveUuser(new Uuser(0, "ilyas", passwordEncoder.encode("1234"), true));
//		userService.saveUuser(new Uuser(0, "aksel", passwordEncoder.encode("1234"), true));

//		
		// System.out.println(userService.readById(1).getRoles().get(0).getRole());
		// System.out.println(userService.findUserByEmailAndPassword("ilyas@fms.com",
		// "1234").getRoles());

		/*
		 * Save some categories
		 */

//		Category pc = new Category("PC");
//		Category smartphone = new Category("SMARTPHONE");
//		Category tablet = new Category("TABLET");
//		Category hardware = new Category("HARDWARE");
//		Category other = new Category("OTHER");
//		categoryService.saveCategory(pc);
//		categoryService.saveCategory(smartphone);
//		categoryService.saveCategory(tablet);
//		categoryService.saveCategory(hardware);
//		categoryService.saveCategory(other);

		/*
		 * Save some Articles
		 */
//
//		articleService.saveArticle(new Article(null, "S10", "Samsung", (double) 350, 1, smartphone));
//		articleService.saveArticle(new Article(null, "S7", "Samsung", 300., 1, smartphone));
//		articleService.saveArticle(new Article(null, "MI10", "Xiomi", 250D, 1, smartphone));
//		articleService.saveArticle(new Article(null, "GalaxyTab", "Samsung", (double) 150, 1, tablet));
//		articleService.saveArticle(new Article(null, "EliteBook 16G", "HP", (double) 1350, 1, pc));
//		articleService.saveArticle(new Article(null, "Ipad", "Apple", (double) 100, 1, tablet));
//		articleService.saveArticle(new Article(null, "Chargeur PC", "hp", (double) 80, 1, hardware));
//
//		articleService.saveArticle(new Article(null, "S11", "Samsung", (double) 350, 1, smartphone));
//		articleService.saveArticle(new Article(null, "S12", "Samsung", 300., 1, smartphone));
//		articleService.saveArticle(new Article(null, "MI09", "Xiomi", 250D, 1, smartphone));
//		articleService.saveArticle(new Article(null, "tab enfant", "Gulli", (double) 150, 1, tablet));
//		articleService.saveArticle(new Article(null, "EliteBook 16G", "HP", (double) 1350, 1, pc));
//		articleService.saveArticle(new Article(null, "Ipad", "Apple", (double) 150, 1, tablet));
//		articleService.saveArticle(new Article(null, "casque ", "hp", (double) 80, 1, hardware));
//		articleService.saveArticle(new Article(null, "S11", "Samsung", (double) 350, 1, other));
//		articleService.saveArticle(new Article(null, "S12", "Samsung", 300., 1, other));
//		articleService.saveArticle(new Article(null, "MI09", "Xiomi", 250D, 1, other));
//		articleService.saveArticle(new Article(null, "tab enfant", "Gulli", (double) 150, 1, other));
//		articleService.saveArticle(new Article(null, "EliteBook 16G", "HP", (double) 1350, 1, other));
//		articleService.saveArticle(new Article(null, "Ipad", "Apple", (double) 100, 1, other));
//		articleService.saveArticle(new Article(null, "casque ", "hp", (double) 80, 1, other));

//		while (true) {
//			System.out.println("Bienvenue dans votre LIBRAIRIE. Voici la liste de nos livres ");
//			welcomeMenu();
//		}

		/*
		 * Some requests TEST
		 */
//		System.out.println("\n-------------------------Read all articles------------------");
//		articleService.realAll().forEach(a -> {
//			System.out.println(a);
//		});
//		// OR
////		for (Article article : articleRepository.findAll()) 
////			System.out.println(article);
//
//		System.out.println("\n------------------------Read article by Id------------------");
//		System.out.println(articleService.readById(2L));
//
//		System.out.println("\n----------------------Delete article by Id------------------");
////		if(articleRepository.findById(2L).get() != null)
////			articleRepository.deleteById(2L);
//
//		System.out.println("\n----------------------Update article ------------------------");
//
//		System.out.println("\n----------------------Article by category id ------------------------");
//		articleService.readArticleByCatgoryId(2L).forEach(a -> {
//			System.out.println(a);
//		});
//
//		System.out.println("\n----------------------Article by category name ------------------------");
//		articleService.readArticleByCatgoryName(CategoryEnum.PC).forEach(a -> {
//			System.out.println(a);
//		});
//
//		System.out.println("\n----------------------Article page by page ------------------------");
//		int size = 5;// Each page contains "size" elements
//		int page = 0; // First page start with "page" (0 in this case) index
//
//		/*
//		 * Number of pages
//		 */
//		int articleTotalPages = articleService.readArticlesPageByPage(page, size).getTotalPages();
//
//		/*
//		 * Number of total elements
//		 */
//		long totalArticlesElements = articleService.readArticlesPageByPage(page, size).getTotalElements();
//
//		/*
//		 * Pagination show
//		 */
//		for (page = 0; page < articleTotalPages; page++) {
//			int pageNbElmts = articleService.readArticlesPageByPage(page, size).getNumberOfElements(); // number of
//																										// items on the
//																										// current page
//			// Elements Page
//			System.out.println("\nPage Number " + page + " contains " + pageNbElmts + " elements:");
//			articleService.readArticlesPageByPage(page, size).forEach(a -> {
//				System.out.println(a);
//			});
//		}
//
//		System.out.println("\n---------Article page by page and with brand key word -----------");
//		articleService.findByPageByPageAndKeyWord("sam", PageRequest.of(0, 10)).forEach(a -> {
//			System.out.println(a);
//		});
	}

	private void authentication() {
		if (login != null)
			System.out.println("vous êtes déjà connecté");
		else {
			System.out.println("saisissez votre email : ");
			String email = scanner.next();
			System.out.println("saisissez votre password : ");
			String pwd = scanner.next();

			Uuser user = userService.findUuserByUserName(email);
			if (user != null) {
				idUser = user.getUserId();
				/*
				 * Check user role
				 */
				for (int i = 0; i < user.getRoles().size(); i++) {
					if (user.getRoles().get(i).getRole() == "ADMIN")
						adminMenu();
					else
						usersMenu(idUser);
				}
			} else
				System.out.println("login ou password incorrect");
		}
	}

	/**
	 * 
	 */
	private void welcomeMenu() {
		int menuChoice = -1;
		while (menuChoice != 0) { // (0) to exit menu
			try {
				System.out.println("\n----------------------------- SHOP APP -------------------------" + "\n"
						+ "ADMIN                                                  enter (1)\n"
						+ "USERS                                                  enter (2)\n"
						+ "LOGIN                                                  enter (3)\n"
						+ "----------------------------------------------------------------");

				/** Only integer entries accepted */
				menuChoice = (int) getPositiveIntegerInput(scanner, "\nFaite votre choix!");
				switch (menuChoice) {
				case 1:
					authentication();
					// adminMenu();
					break;

				case 2:
					usersMenu(idUser);
					break;

				case 3:
					authentication();
					break;

				default:
					System.out.println("Wrong entry: ONLY INTEGERS ENTRIES ( 0 to 5)");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void usersMenu(long userId) {
		int menuChoice = -1;
		while (menuChoice != 0) { // (0) to exit menu
			try {
				System.out.println("-------------------------- STORE MENU --------------------------" + "\n"
						+ "Pour afficher TOUS les ARTICLES,                       enter (1)\n"
						+ "Pour afficher les articles PAR CATEGORIE,              enter (2)\n"
						+ "Pour AJOUTER un article au PANIER,                     enter (3)\n"
						+ "Pour SUPPRIMER un article dans le PANIER               enter (4)\n"
						+ "Pour AFFICHER et VALIDER le PANIER,                    enter (5)\n"
						+ "Pour recuperer la FACTURE-COMMANDE (admin),            enter (6)\n"
						+ "Pour afficher TOUS les ARTICLES page par page,         enter (7)\n"
						+ "SORTIR de l'application,                               enter (0)\n"
						+ "----------------------------------------------------------------");

				/** Only integer entries accepted */
				menuChoice = (int) getPositiveIntegerInput(scanner, "\nFaite votre choix!");
				switch (menuChoice) {
				case 1:
					showArticles(articleService.realAll());
					break;

				case 2:
					showAllCategories(categoryService.readAllCategories());
					Long idCategory = getPositiveIntegerInput(scanner, "\nEntrez l'ID de la CATEGORY concernée!");
					showArticles(articleService.readArticleByCatgoryId(idCategory));
					break;

				case 3:
					showArticles(articleService.realAll());
					Long idArticle = getPositiveIntegerInput(scanner, "\nEntrez l'ID de l'article que vous souhaitez!");
					articleService.addArticleToCart(idArticle);
					break;

				case 4:
					showMyCart(articleService.getMyCart());
					Long idArticle1 = getPositiveIntegerInput(scanner,
							"\nEntrez l'ID de l'article que vous souhaitez RETIRER!");
					// shopJob.removeArticleFromBucket(idArticle1);
					break;

				case 5:
					validateCart(articleService.getMyCart(), userId);
					break;

				case 6:
					int orderId = (int) getPositiveIntegerInput(scanner, "\nEntrez l'ID de la commande concernée!");
					// getInvoice(orderId);
					break;

				case 7:
					showArticlesPageByPage();
					// getInvoice(orderId);
					break;

				case 0:
					menuChoice = 0;
					break;

				default:
					System.out.println("Wrong entry: ONLY INTEGERS ENTRIES ( 0 to 5)");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * 
	 * @param scanner2
	 * @param string
	 * @return
	 */
	private int getPositiveOneOrTwo(Scanner scanner2, String string) {
		String menuresponse = "";
		while (true) {
			System.out.println(string);
			try {
				menuresponse = scanner.next();
				if (Integer.parseInt(menuresponse) == 1 || Integer.parseInt(menuresponse) == 2)
					break;
				System.out.println("La réponse doit être numerique et positive entre 1 & 2");
			} catch (NumberFormatException e) {
				System.out.println("La réponse doit être numerique et positive entre 1 ou 2");
			}
		}
		return Integer.parseInt(menuresponse);

	}

	private void validateCart(Map<Long, Article> myCart, long userId) {
		/* Get an empty message where cart is empty */
		if (myCart.isEmpty())
			System.out.println("\nYour bucket si empty!\n");
		else {
			showMyCart(myCart);

			/* Suggest to validate and confirm the buy */
			int validate = getPositiveOneOrTwo(scanner, "Voulez-vous VALIDER votre panier:  ?(1:oui/ 2:non)");

			if (validate == 1) {
				int confirm = getPositiveOneOrTwo(scanner, "Voulez-vous CONFIRMER LA VALIDATION:  ?(1:oui/ 2:non)");

				/* Save the order information in DB and finally delete cart */
				if (confirm == 1) {
					double totalprice = 0;

					long lastOrderId = orderService.getLastOrderId(); // get the last order ID
					/*
					 * As we can't add or update a child (orderitem) row (foreign key constraint,
					 * start by save a default parent row (order)
					 */
					orderService.insertOrderLineToOrder(new Order(0, new Date(), totalprice, null, null));

					/* each line in the bucket corresponds to an item in the order table */
					for (Map.Entry<Long, Article> entry : myCart.entrySet()) {
						/* get the price for each item */
						// double itemPrice = entry.getValue().getPrice() *
						// entry.getValue().getQuantity();
						/* Start saving items */
						// shopJob.insertOrderLine(new OrderLine(0, entry.getValue().getId(),
						// entry.getValue().getQuantity(), itemPrice, lastOrderId + 1, lastOrderId +
						// 1));
						/* Get the order total price */
						// totalprice += itemPrice;
					}

					/*
					 * Update the last default order saving after that all order items were saved
					 * (and clear the bucket)
					 */
					// shopJob.updateOrder(new Order(lastOrderId + 1, new Date(), totalprice,
					// userId));
					myCart.clear();

					/**/
					int getInvoice = getPositiveOneOrTwo(scanner,
							"Voulez-vous récuperer votre facture:  ?(1:oui/ 2:non)");
					if (getInvoice == 1)
						// shopJob.generatetInvoice(lastOrderId + 1);
						System.out.println("Merci et à bientôt.");
				}
			}
		}
	}

	/**
	 * 
	 * @param myCart
	 */
	private void showMyCart(Map<Long, Article> myCart) {
		/* Table header */
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------");
		System.out.print(String.format("|%-5s|%-36s|%-18s|%-12s|%-10s|%-12s|", "ID", "DESCRIPTION", "BRAND",
				"UNITY PRICE", "QUANTITY", "TOTAL PRICE"));
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------");

		/**
		 * Total price for each selected training and total price for the whole bucket
		 */
		Double productTotalPrice = 0.0;
		Double TotalPrice = 0.0;
		/* Start to fill the table body with the selected training */
		for (java.util.Map.Entry<Long, Article> entry : myCart.entrySet()) {
			productTotalPrice = entry.getValue().getPrice() * entry.getValue().getQuantity();
			System.out.println(String.format("|%-5s|%-36s|%-18s|%-12s|%-10s|%-12s|", entry.getKey(),
					entry.getValue().getDescription(), entry.getValue().getBrand(), entry.getValue().getPrice(),
					entry.getValue().getQuantity(), productTotalPrice + " €"));
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
			TotalPrice += productTotalPrice;
		}

		/*
		 * The last table line: a small choice menu and the total bucket price in EURO
		 */
		System.out.println(String.format("\n|%-82s|%-15s|",
				"Totals:       -> -> ->         -> -> ->         -> -> ->         -> -> ->     ", TotalPrice + " €"));
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");

	}

	private void adminMenu() {
		int menuChoice = -1;
		while (menuChoice != 0) { // (0) to exit menu
			try {
				System.out.println("\n------------------------ ADMIN CONSOLE -------------------------" + "\n"
						+ "*************************** CATEGORIES *************************\n"
						+ "Pour Afficher toutes les CATEGORIES                    enter (1)\n"
						+ "Ajouter une categorie                                  enter (2)\n"
						+ "Supprimer une categorie                                enter (3)\n"
						+ "\n************************* ARTICLES ****************************\n"
						+ "Pour afficher les ARTICLES,                            enter (4)\n"
						+ "Pour afficher tous les article page par page,          enter (5)\n"
						+ "Tous les ARTICLES d’une CATEGORIE                      enter (6)\n"
						+ "Pour AJOUTER un ARTICLE,                               enter (7)\n"
						+ "Pour SUPPRIMER un article         ,                    enter (8)\n"
						+ "Pour METTRE A JOUR un ARTICLE,                         enter (9)\n" + "\n"
						+ "SORTIR de l'application,                               enter (0)\n"
						+ "----------------------------------------------------------------");

				/** Only integer entries accepted */
				menuChoice = (int) getPositiveIntegerInput(scanner, "\nFaites votre choix!");
				switch (menuChoice) {

				case 1:
					showAllCategories(categoryService.readAllCategories());
					break;

				case 2:
					addCategory();
					break;

				case 3:
					deleteCategory();
					break;

				case 4:
					showArticles(articleService.realAll());
					break;

				case 5:
					showArticlesPageByPage();
					break;

				case 6:
					articlesByCategoryId();
					break;

				case 7:
					addArticle();
					break;

				case 8:
					deleteArticle();
					break;

				case 9:
					updateArticle();
					break;

				case 0:
					menuChoice = 0;
					break;

				default:
					System.out.println("Wrong entry: ONLY INTEGERS ENTRIES ( 0 to 5)");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void deleteCategory() {
		showAllCategories(categoryService.readAllCategories());
		int idCategory = (int) getPositiveIntegerInput(scanner,
				"\nEntrez l'ID de la categorie que vous souhaitez supprimer!");
		categoryService.deleteCategory(idCategory);

	}

	private void addCategory() {
		System.out.println("Entrer le nom de la category :");
		String category = scanner.nextLine();
		category = scanner.nextLine();
		categoryService.saveCategory(new Category(category));

	}

	/**
	 * 
	 */
	private void updateArticle() {
		String description = null;
		String brand = null;
		Double price = null;
		String catName = null;
		String answer = "";
		Long idCat = null;
		showArticles(articleService.realAll());
		int idArticle = (int) getPositiveIntegerInput(scanner,
				"\nEntrez l'ID de l'article que vous souhaitez- modifier!");
		Article article = articleService.readById((long) idArticle);

		System.out.println("DESCRPTION: " + article.getDescription());
		System.out.println("Voudriez-vous la changer: ? yes/no");
		answer = yesOrNoChoice();
		if (answer.equalsIgnoreCase("yes")) {
			description = scanner.nextLine();
			description = scanner.nextLine();

		} else
			description = article.getDescription();

		System.out.println("MARQUE: " + article.getBrand());
		System.out.println("Voudriez-vous la changer: ? yes/no");
		answer = yesOrNoChoice();
		if (answer.equalsIgnoreCase("yes")) {
			brand = scanner.nextLine();
			brand = scanner.nextLine();

		} else
			brand = article.getBrand();

		System.out.println("PRIX: " + article.getPrice());
		System.out.println("Voudriez-vous le changer: ? yes/no");
		answer = yesOrNoChoice();
		if (answer.equalsIgnoreCase("yes"))
			price = scanner.nextDouble();
		else
			price = article.getPrice();

		System.out.println("CATEGORIE: " + article.getCategory().getName());
		System.out.println("Voudriez-vous la changer: ? yes/no");
		answer = yesOrNoChoice();
		if (answer.equalsIgnoreCase("yes")) {
			categoryService.readAllCategories().forEach(c -> {
				System.out.print(c.getId() + ": " + c.getName() + "  /  ");
			});
			System.out.println("Choisissez la categorie en tapant l'ID correspondant ?");
			idCat = scanner.nextLong();
		} else
			catName = article.getCategory().getName();

		articleService.saveArticle(
				new Article((long) idArticle, description, brand, price, 1, categoryService.getCategoryById(idCat)));
	}

	private String yesOrNoChoice() {
		String choice = scanner.next();
		while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
			System.out.println("Sorry, answer yes or no : ?(yes/no)");
			choice = scanner.next();
		}
		return choice;
	}

	/**
	 * 
	 */
	private void articlesByCategoryId() {
		showAllCategories(categoryService.readAllCategories());
		int idCat = (int) getPositiveIntegerInput(scanner, "\nEntrez l'ID de la categorie que vous souhaitez!");
		showArticles(articleService.readArticleByCatgoryId((long) idCat));
	}

	/**
	 * 
	 * @param readArticleByCatgoryId
	 */
	private void showAllCategories(List<Category> categories) {
		System.out.println("------------------------------------------");
		System.out.println("|ID  | CATEGORY NAME                     |");
		System.out.println("-----+-----------------------------------+");//

		/* * Display the table body: Browse the training HashMap */
		for (Category c : categories) {
			System.out.println(String.format("|%-4s|%-35s|", c.getId(), c.getName()));
			System.out.println("-----+-----------------------------------+");
		}

	}

	private void addArticle() {

		System.out.println("Description de l'article ?");
		String description = scanner.nextLine();
		description = scanner.nextLine();

		System.out.println("Marque de l'article ?");
		String brand = scanner.next();
		// brand = scanner.next();
		System.out.println("Prix de l'article ?");
		Double price = scanner.nextDouble();
		System.out.println("Associer une categorie à l'article ?");
		categoryService.readAllCategories().forEach(c -> {
			System.out.print(c.getId() + ": " + c.getName() + "  /  ");
		});
		System.out.println("Choisissez la categorie en tapant l'ID correspondant ?");
		Long idCat = scanner.nextLong();
		articleService
				.saveArticle(new Article(null, description, brand, price, 1, categoryService.getCategoryById(idCat)));
	}

	private void deleteArticle() {
		showArticles(articleService.realAll());
		int idArticle = (int) getPositiveIntegerInput(scanner, "\nEntrez l'ID de l'article que vous souhaitez!");
		articleService.deleteArticleById((long) idArticle);

	}

	private void showArticlesPageByPage() {
		int size = 5;// Each page contains "size" elements
		int page = 0; // First page start with "page" (0 in this case) index

		/*
		 * Number of pages
		 */
//		int articleTotalPages = articleService.readArticlesPageByPage(page, size).getTotalPages();

		/*
		 * Number of total elements
		 */
//		long totalArticlesElements = articleService.readArticlesPageByPage(page, size).getTotalElements();

		/*
		 * Pagination show
		 */
		showArticles(articleService.readArticlesPageByPage(page, size).getContent());

		int menuChoice = -1;
		while (menuChoice != 0) {
			try {
				System.out.println("        (touche 1) <<<<<<<<<<<<<<<<  " + (page + 1) + "/" + size
						+ "  >>>>>>>>>>>>>>>> (touche 2)" + "                SORTIR (touche 0) |"
						+ "\n--------------------------------------------------------------------------------------------------------");

				/** Only integer entries accepted */
				menuChoice = (int) getPositiveIntegerInput(scanner, "");
				System.out.print(" ");
				/*
				 * Element of current page
				 */
				int currentPageElts = articleService.readArticlesPageByPage(page, size).getNumberOfElements();
				switch (menuChoice) {
				case 1:
					if (page > 0) {
						clearPreviousPrintedPage(currentPageElts);
						showArticles(articleService.readArticlesPageByPage(page - 1, size).getContent());
						page--;
					} else {
						clearPreviousPrintedPage(currentPageElts);
						showArticles(articleService.readArticlesPageByPage(page, size).getContent());
					}
					break;

				case 2:
					if (page < size - 1) {
						clearPreviousPrintedPage(currentPageElts);
						showArticles(articleService.readArticlesPageByPage(page + 1, size).getContent());
						page++;
					} else {
						clearPreviousPrintedPage(currentPageElts);
						showArticles(articleService.readArticlesPageByPage(page, size).getContent());

					}
					break;

				case 0:
					menuChoice = 0;
					break;

				default:
					System.out.println("Wrong entry: ONLY INTEGERS ENTRIES ( 0 to 5)");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

//		for (page = 0; page < articleTotalPages; page++) {
//			int pageNbElmts = articleService.readArticlesPageByPage(page, size).getNumberOfElements(); // number of
//																										// items on the
//																										// current page
//			// Elements Page
//			System.out.println("\nPage Number " + page + " contains " + pageNbElmts + " elements:");
//			showArticles(articleService.readArticlesPageByPage(page, size).getContent());
////			articleService.readArticlesPageByPage(page, size).forEach(a -> {
////				System.out.println(a);
////			});
//		}

	}

	private void clearPreviousPrintedPage(int currentPageElts) {
		for (int i = 0; i < (currentPageElts * 2) + 2; i++)
			System.out.print(
					"\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
	}

	/**
	 * Gestion d'erreurs de flux entrée sortie
	 * 
	 * @param scanner
	 * @param string
	 * @return un nombre positif (>0)
	 */
	private static long getPositiveIntegerInput(Scanner scanner, String string) {
		String menuresponse = "";
		while (true) {
			System.out.print(string);
			try {
				menuresponse = scanner.next();
				if (Integer.parseInt(menuresponse) >= 0)
					break;
				System.out.println("La réponse doit être numerique et positive >= 0");
			} catch (NumberFormatException e) {
				System.out.println("La réponse doit être numerique et positive >= 0");
			}
		}
		return Long.parseLong(menuresponse);
	}

	/**
	 * Affiche tous les livre à l'ouverture de l'appli
	 * 
	 * @param books
	 */
	private static void showArticles(List<Article> articles) {
		// Build the table header
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|ID  | DESCRIPTION                       | BRAND                     | CATEGORY             |PRICE (€) |");
		System.out.println(
				"-----+-----------------------------------+---------------------------+----------------------+----------+");//

		/* * Display the table body: Browse the training HashMap */
		for (Article a : articles) {
			System.out.println(String.format("|%-4s|%-35s|%-27s|%-22s|%-10s|", a.getId(), a.getDescription(),
					a.getBrand(), a.getCategory().getName(), a.getPrice()));
			System.out.println(
					"-----+-----------------------------------+---------------------------+----------------------+----------+");
		}

	}

}
