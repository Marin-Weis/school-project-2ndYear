CREATE TABLE IF NOT EXISTS Compte_Client (
                                             numCompte INT REFERENCES Compte (numCompte),
    numClient INT REFERENCES Client (numClient),
    PRIMARY KEY (numCompte, numClient)
    );

ALTER TABLE Client
    ALTER COLUMN nomClient SET NOT NULL,
    ALTER COLUMN prenomClient SET NOT NULL,
    ADD CONSTRAINT chk_age CHECK (ageClient >= 18);
    ADD CONSTRAINT CHK_Age_minimale CHECK (ageClient > 0)

ALTER TABLE Compte
    ADD CONSTRAINT CHK_solde CHECK (solde > 0)

ALTER TABLE Operation
    ADD CONSTRAINT CHK_montant CHECK (montant > 0)

ALTER TABLE Agent
    ALTER COLUMN estDirecteur SET DEFAULT false;

ALTER TABLE Agent
    ADD CONSTRAINT DF_directeur DEFAULT False FOR estDirecteur

ALTER TABLE Agence
    ADD CONSTRAINT UQ_tel UNIQUE (telAgence)





