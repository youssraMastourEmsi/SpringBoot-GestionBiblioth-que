Avant de commencer l'explication du projet il faut tout dabord comprendre quelques notion de base sur le Spring Boot. Donc premièrement Spring utilise le principe ORM (Object Relational Mapping), pour but d'interagir avec la base de données sans avoir besoin de lancer des requêtes SQL ou quelques soit le type de la base de données, pour ce faire il suffit de crèer des objets et interagir avec ces objets et exécuter le code pour avoir le résultat dans la base de données utilisé ou lié. Dans notre cas on a une base de données MySQL, et il faut qu'on crèe une table Livre et effectuer les itération CRUD sur cette dernière, CRUD signifie Creation, Lecture, Modification et Suppression (Create, Read, Update, Delete). Pour ce faire on aura besoin de crèer 3 packages:
	1- Model		==> Dans lequel on crée notre Class (Définition de l'objet) à convertire on Table MySQL, avec spécification de tout type et conditions et construction des constucteurs, getters et setters.
	2- Repository 	==> un repository est un objet dont la responsabilité est de récupérer une collection d'objets. Les repositories Doctrine ORM ont accès à deux objets principalement :
		l'EntityManager, que vous connaissez déjà; et un QueryBuilder (un constructeur de requêtes) pour vous aider à faire des recherches plus fines dans la collection d'entités disponibles.
	3- Controller	==> Dans lequel on passe la majorité de notre temps, là, on crée les fonctionnalité CRUD ou personnalisé d'interaction avec les objets. Dnas le controller on spécifie 4 choses: 
			1- Le route du mapping (Ex.: @RequestMapping("/emsi_api"))
			2- Les méthodes de requête dans chaque service (Méthode) (Ex.: @GetMapping("/livres"))
			3- La définition des méthodes (Ex.: public List<Livre> getAllLivres())
			4- Si c'est le cas la reception des informations soit en paramètre (Ex.: @GetMapping("/livres/{id}")), soit en body (Ex.: @RequestBody Livre livreDetails) qui est indiqué dans le paramètre de la méthode.
	PS: On peux rajouter un 4eme qui est le Exception package qui s'occupe de la création des types d'exceptions, pour bien structurer les messages d'exceptions

Pour pouvoir lancer l'application il faut lancer MySQL et créer une base de données avec le nom suivant: librarydb
Ensuite vous pouvez lancer le backend. Comme il est noté dans les consignes de l'exercice, ce projet consiste la création d'un model (Table) Livre qui a comme condition:
	1- La valeur de ISBN doit être unique.
		==> Ex.: @Column(name = "ISBN", unique=true, nullable = false, updatable = false)
	2- L’utilisateur ne peut pas insérer des valeurs nulles.
		==> Ex.: @Column(name = "DateDerniereConsultation", nullable = false)
	3- L’utilisateur ne doit pas avoir la possibilité pour modifier les attributs "Maison d’édition" et "ISBN"
		==> Ex.: @Column(name = "maisonEdition", nullable = false, updatable = false)
	4- Les livres doivent être triés par ordre croissant.
		==> Ex.: livreRepository.findAll(Sort.by(Sort.Direction.ASC, "titre"));

Le fichier de Collection Postman est composé de 5 entités:
	1- POST => http://localhost:8080/emsi_api/livres => JSON Data
		==> Ajouter un livre
	2- GET => http://localhost:8080/emsi_api/livres
		==> Lister les livres
	3- PUT => http://localhost:8080/emsi_api/livres/3 => id dans le paramètre
		==> Modifier un livre
	4- GET => http://localhost:8080/emsi_api/livres/3 => id dans le paramètre
		==> Afficher un livre
	5- DELETE => http://localhost:8080/emsi_api/livres/3 => id dans le paramètre
		==> Supprimer un livre

Le git contient un dossier dans lequel vous trouverai le projet backend en Spring avec le nom "GestionDeBibliotheque", et un fichier avec le nom "SpringBoot-Gestion de Bibliothèque.postman_collection.json" qui contient une collection des requètes sur le backend en utilisant Postman (Vous pouvez juste importer la collection et exécuter le code pour tester toutes les fonctionnalités et la validité des conditions cité dans l'exercice).