CREATE TABLE IF NOT EXISTS products (
    title varchar(256) NOT NULL,
    article varchar(50) NOT NULL PRIMARY KEY,
    description text NOT NULL,
    cost float,
    imageURL varchar(256)
);

