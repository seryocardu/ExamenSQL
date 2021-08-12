SELECT
  pizza.id,
  pizza.name,
  SUM(ingredient.price*quantity) AS precio
FROM
  pizza
  INNER JOIN pizza_ingredient ON pizza.id = pizza_ingredient.id_pizza
  INNER JOIN ingredient ON pizza_ingredient.id_ingredient = ingredient.id
WHERE
  pizza.name LIKE 'Carbonara'
GROUP BY
  pizza.id,
  pizza.name;