CREATE TABLE IF NOT EXISTS products (
    title varchar(256) NOT NULL,
    article varchar(50) NOT NULL PRIMARY KEY,
    description text NOT NULL,
    cost float,
    imageURL varchar(256));

insert into products (title, article, description, cost, imageURL)
VALUES
    ('Рис', '12345', 'Описание продукта 1', 10.99, '/img/no-photo.jgp'),
    ('Молоко', '54321', 'Описание продукта 2', 7.99, '/img/no-photo.jgp'),
    ('Хлеб', '98765', 'Описание продукта 3', 4.99, '/img/no-photo.jgp'),
    ('Мясо', '43210', 'Описание продукта 4', 19.99, '/img/no-photo.jgp'),
    ('Фрукты', '87654', 'Описание продукта 5', 12.99, '/img/no-photo.jgp');


