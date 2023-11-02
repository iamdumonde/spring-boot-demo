## ctrl ; | pour générer les getters: setters, construtors
## Changement du port de mon application
1. rentrer dans le dossier ressources qui se trouve dans main | toucher au fichier ressources | modifier le fichier "application.properties" | dans ce fichier on met "server.port= 3000(le port qu'on veut)"
2. créer un fichier "application.yml" dans lequel on écrit la même chose que dans "application.properties" mais en indentant le code

## YAML: YAML Markup Language

## Endpoints
Création des urls qui doivent renvoyer des données

## @RestController
Lorsqu'une classe est annotée avec ``@RestController`` spring considère que chaque méthode de cette classe renvoie des données à représenter directement dans le corps de la réponse HTTP, en tant que données (JSON ou XML).


## @RequestMapping
liaison entre une route et une méthode
# Précision de la méthode de route qu'on utiliser
@RequestMethod
1. méthode GET
``@RequestMapping(path ="/hello", method = RequestMethod.GET)``
2. 	méthode POST
``@RequestMapping(path ="/hello", method = RequestMethod.POST)``

# Pour raccourcir tout ce qui est en haut on met
@GetMapping("/hello")
@PostMapping("/hello")

## Les méthodes : définir sur un objet java
1. equals() :
   Permet de compare l'objet courant avec un autre objet passé en argument pour déterminer s'ils sont égaux ou non.

2. hashCode() :
   Cette méthode retourne un code de hachage (numéro calculé à partir des valeurs internes de l'objet) entier pour l'objet. Il est important que si deux objets sot égaux selon la méthode equals(), ils aient le même code de hachage.

3. toString() :
   Cette méthode retourne une chaîne de caractère représentant l'objet. Il est recommandé de redéfinir cette méthode dans nos classes pour retourner une représentation plus significative de l'objet.

## @Entity
Entité permettant d'envoyer les informations dans la base de données. En plus @Entity en haut d'une classe transforme cette classe en une entité

## un Bean 
Est l'instance d'une classe qui est automatiquement générée par Java
## Ajouter des dépendances
spring-data-starter-jpa
mysql

mysql -u root -p

CREATE DATABASE db_examples CHARACTER SET utf8 COLLATE 