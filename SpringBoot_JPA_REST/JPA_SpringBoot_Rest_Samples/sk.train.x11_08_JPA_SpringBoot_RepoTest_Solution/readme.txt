JPA durch Spring gemanaged + deklarative Transaktionsunterstützung

+ Repository-Generierung mit individuellen Ergänzungen

+ Statt kompletter Test jetzt nur Slice-Test für den JPA-Layer.
Anmerkung: Sofern wir auf "@DataJpaTest" wechseln, um nur den Repository-Layer 
zu testen, muss der "CommandLineRunner" aus der Konfig entfernt werden, 
da dieser im Starter enthalten ist und versucht wird, diesen zu erzeugen.
Das scheitert aber, da er nicht zu den für den Test notwendigen Komponenten 
gehört (hier steht sich Spring ein wenig selbst im Weg!).

