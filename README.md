# Mon Projet Spring Boot avec Docker

Ce projet est une application Spring Boot déployée avec Docker, utilisant MariaDB comme base de données, avec monitoring configuré via Prometheus et visualisation via Grafana.

## Prérequis

Assurez-vous d'avoir installé les éléments suivants sur votre machine :
- Docker
- Docker Compose
- Git (optionnel, pour cloner le dépôt)

## Installation

Suivez ces étapes pour démarrer le projet :

### Clonage du dépôt

Si le code est hébergé sur un dépôt Git, clonez-le en utilisant :


### Lancement des services

Construisez et lancez tous les services définis dans le `docker-compose.yml` avec :


## Structure du projet

Voici un aperçu de la structure principale du projet :

- `src/`: Dossier contenant le code source de l'application Spring Boot.
- `Dockerfile`: Fichier Docker pour construire l'image de l'application Spring Boot.
- `docker-compose.yml`: Fichier Docker Compose pour orchestrer les services.
- `prometheus.yml`: Configuration de Prometheus pour la collecte des métriques.
- `README.md`: Ce fichier explicatif.

## Configuration

### Application Spring Boot

L'application est configurée pour se connecter à une base de données MariaDB et expose des métriques via `/actuator/prometheus`.

### MariaDB

Configurations de la base de données :

- **Username:** mohamed
- **Password:** mohamed
- **Database Name:** compagnie

### Prometheus

Prometheus est configuré pour collecter des métriques de l'application Spring Boot. Il est accessible via `http://localhost:9090`.

### Grafana

Grafana est utilisé pour visualiser les métriques collectées par Prometheus. Vous pouvez accéder à Grafana via :


Les identifiants par défaut sont `admin` pour l'utilisateur et `admin` pour le mot de passe (il vous sera demandé de le changer lors de la première connexion).

## Utilisation

Après le démarrage des services, l'application Spring Boot sera accessible à l'adresse :


## Surveillance

- **Prometheus:** Consultez la console de Prometheus et les métriques collectées à `http://localhost:9090`.
- **Grafana:** Connectez-vous à `http://localhost:3000` pour configurer des tableaux de bord et visualiser les données de performance.

## Contribution

Les contributions à ce projet sont les bienvenues. Suivez les bonnes pratiques de développement et soumettez des Pull Requests pour toute modification proposée.
