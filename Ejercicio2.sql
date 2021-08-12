INSERT INTO
  pizza (id, name, url)
VALUES
  (UUID_TO_BIN(UUID()), 'Carbonara', 'URL');
INSERT INTO
  ingredient (id, name, price)
VALUES
  (UUID_TO_BIN(UUID()), 'tomate', 1.0);
INSERT INTO
  ingredient (id, name, price)
VALUES
  (UUID_TO_BIN(UUID()), 'queso', 3.0);
BEGIN TRAN T1;
INSERT INTO
  pizza_ingredient (id, quantity, id_pizza, id_ingredient)
VALUES
  (
    UUID_TO_BIN(UUID()),
    1,
    (
      SELECT
        id
      FROM
        pizza
      WHERE
        name = 'Carbonara'
    ),
    (
      SELECT
        id
      FROM
        ingredient
      WHERE
        name = 'tomate'
    )
  );
INSERT INTO
  pizza_ingredient (id, quantity, id_pizza, id_ingredient)
VALUES
  (
    UUID_TO_BIN(UUID()),
    1,
    (
      SELECT
        id
      FROM
        pizza
      WHERE
        name = 'Carbonara'
    ),
    (
      SELECT
        id
      FROM
        ingredient
      WHERE
        name = 'queso'
    )
  );
COMMIT TRAN T1;