# Rapport – Choix techniques et Difficultés rencontrées

**Nom :** Weis

**Prénom :** Marin

**Groupe :** C1

**Année :** 2025–2026

---

## Choix techniques

J’ai créé une architecture contenant un conteneur pour la base PostgreSQL et un autre pour l’application Java afin de séparer clairement les deux parties du projet. J’ai mis en place un réseau Docker privé nommé app_network pour permettre aux deux conteneurs de communiquer entre eux sans exposer la base de données vers l’extérieur. J’ai configuré un Dockerfile multi-stage pour compiler le projet avec Maven dans un premier stage, puis exécuter un JAR allégé dans un second stage. J’ai utilisé le plugin Maven Shade pour générer un JAR exécutable contenant toutes les dépendances nécessaires. J’ai également ajouté un fichier init.sql qui s’exécute automatiquement au démarrage afin de créer les tables de la base de données.

---

## Difficultés rencontrées

J’ai rencontré des difficultés pour connecter l’application à PostgreSQL, car j’utilisais localhost au lieu du nom du service Docker db, ce qui empêchait la communication entre les conteneurs. J’ai aussi eu des problèmes pour tester la base, car le port PostgreSQL n’était pas exposé, ce qui ne me permettait pas d’utiliser un outil externe. J’ai dû corriger plusieurs fois le chemin du JAR dans Docker, car l’application ne se lançait pas correctement. La configuration du plugin Shade n’était pas bonne au début, ce qui empêchait le JAR d’avoir la bonne classe principale. J’ai également mis du temps à comprendre le fonctionnement du réseau Docker et la manière dont les conteneurs se résolvent entre eux. Enfin, j’ai dû corriger des erreurs dans le fichier init.sql avant que les tables puissent être générées correctement.
