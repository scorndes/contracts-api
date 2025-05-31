### Règles de Gestion : 
Règles de gestion principales du projet :
* Un utilisateur peut avoir plusieurs portefeuilles.
* Chaque portefeuille est associé à un profil de risque unique.
* Chaque portefeuille contient une répartition en classes d’actifs :
* stockée dans une table portfolio_asset_classes (clé composite : portfolio_id + asset_class_id)
* chaque ligne précise un pourcentage alloué à une classe d’actifs.
* La somme des pourcentages d’un portefeuille doit être de 100 %.
* Un utilisateur a une ou plusieurs adresses, mais une seule est marquée comme principale.
* Les portefeuilles ne doivent pas être créés si l’utilisateur n’a pas d’adresse principale.
* Une simulation de performance peut être lancée sur un portefeuille :
* elle est asynchrone (via MongoDB),
* elle retourne un ID de simulation,
* les résultats peuvent être consultés plus tard.
* Le backend doit valider les allocations en fonction du profil de risque :
* par exemple, un profil prudent ne doit pas avoir plus de 20 % d’actions.
* L’authentification est basée sur JWT (pas de formLogin()).
* Certaines DTOs (comme AddressDto) ne doivent pas exposer les entités entières (ex. User) mais uniquement l’id.
