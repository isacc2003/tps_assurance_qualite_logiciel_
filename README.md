pour tp1 :

Bugs détectés dans le code source
Avant les tests, voici les bugs importants à signaler dans le README.md :
Exercice 1 – Palindrome : les indices i et j sont incrémentés/décrémentés à l'envers → j++ devrait être j-- et i-- devrait être i++.
Exercice 2 – Anagram : la boucle for (int i = 0; i <= s1.length(); i++) fait un <= au lieu de <, ce qui provoque un StringIndexOutOfBoundsException.
Exercice 3 – BinarySearch : la condition while (low < high) devrait être while (low <= high), sinon l'élément en position high n'est jamais trouvé.
Exercice 5 – RomanNumeral : la boucle for (int i = 0; i <= symbols.length; i++) fait <= au lieu de <, provoquant un ArrayIndexOutOfBoundsException. Aussi, la condition while (n > values[i]) devrait être while (n >= values[i]).
Exercice 6 – FizzBuzz : la condition if (n <= 1) devrait être if (n <= 0) pour autoriser n = 1.



pour tp 2 :
Qu'est-ce qu'un test d'intégration ?
Un test d'intégration vérifie que plusieurs composants d'un système fonctionnent correctement ensemble. Contrairement au test unitaire qui isole complètement une classe, le test d'intégration s'intéresse aux interactions entre les modules : est-ce que A appelle bien B ? Est-ce que B reçoit les bons arguments ? Est-ce que la réponse de B est correctement traitée par A ?
Pourquoi utiliser des mocks dans les tests d'intégration ?
Les mocks permettent de :

Isoler le composant sous test de ses dépendances réelles (base de données, API réseau)
Contrôler le comportement des dépendances (simuler un succès, un échec, un cas limite)
Accélérer les tests (pas de latence réseau, pas d'accès disque)
Reproduire des conditions difficiles à provoquer en production (timeout, réponse malformée)

Quelle est la différence entre @Mock et @Spy dans Mockito ?
AnnotationComportementUtilisation@MockL'objet est entièrement factice. Toutes les méthodes renvoient des valeurs par défaut sauf si on les configure avec when(...)Quand on veut remplacer complètement une dépendance@SpyL'objet est réel mais on peut intercepter certaines méthodesQuand on veut tester un objet réel mais surveiller / remplacer certains appels
Qu'est-ce que verify() permet de vérifier ?
verify() permet de s'assurer qu'une méthode d'un mock a bien été appelée, combien de fois, et avec quels arguments. C'est l'assertion centrale des tests d'intégration : on ne vérifie pas seulement le résultat, mais aussi que les interactions entre composants ont bien eu lieu comme prévu.

Quelle est la différence entre thenReturn() et thenThrow() ?

when(mock.method()).thenReturn(value) — programme le mock pour retourner une valeur précise
when(mock.method()).thenThrow(new Exception()) — programme le mock pour lever une exception, ce qui permet de tester les chemins d'erreur

Pourquoi utilise-t-on l'injection de dépendance par constructeur ?
L'injection par constructeur (passer les dépendances en paramètre du constructeur) est préférée car :

Elle rend les dépendances explicites et obligatoires
Elle facilite les tests : on peut injecter un mock directement
Elle favorise l'immuabilité (champs final)
Elle respecte le principe d'inversion de dépendance (SOLID
