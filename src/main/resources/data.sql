-- Utilisateur admin avec mot de passe 'admin'
INSERT INTO
    users (id, username, password, lastname, firstname, birthname, birthdate, email, role)
SELECT
    '00000000-0000-0000-0000-000000000001',
    'admin',
    '$2a$10$pV0kWcVDynqKE6EE7arNjOmSI2uT/syAILwBovhkgvv/R9GCdW/pK',
    'administrateur',
    'root',
    null,
    '1977-05-07 00:00:00',
    'admin@example.com',
    'ROLE_ADMIN'
WHERE
    NOT EXISTS (
        SELECT
            1
        FROM
            users
        WHERE
            ID = '00000000-0000-0000-0000-000000000001'
    );

-- Profils de risque
INSERT INTO
    risk_profiles (id, name, min_bonds)
VALUES
    (1, 'CONSERVATIVE', 40),
    (2, 'BALANCED', 20),
    (3, 'DYNAMIC', 0)
ON CONFLICT DO NOTHING;

-- Catégories d'actifs
INSERT INTO
    asset_categories (id, name)
VALUES
    (1, 'Actions'),
    (2, 'Obligations'),
    (3, 'Crypto')
ON CONFLICT DO NOTHING;