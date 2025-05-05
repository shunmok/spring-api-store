INSERT INTO categories (name)
VALUES ('Fruits'),
       ('Vegetables'),
       ('Dairy'),
       ('Beverages'),
       ('Snacks'),
       ('Bakery'),
       ('Meat'),
       ('Frozen'),
       ('Household'),
       ('Personal Care');

-- Products
INSERT INTO products (name, price, description, category_id)
VALUES ('Fresh Apples', 3.99, 'Crisp and juicy apples, perfect for snacking or baking.', 1),
       ('Organic Carrots', 1.49, 'Fresh organic carrots, great for salads and cooking.', 2),
       ('Whole Milk', 2.99, 'Creamy whole milk sourced from local farms.', 3),
       ('Orange Juice', 3.49, 'Freshly squeezed orange juice with no added sugar.', 4),
       ('Potato Chips', 1.99, 'Crunchy salted potato chips, 200g bag.', 5),
       ('Sourdough Bread', 4.50, 'Freshly baked sourdough bread loaf.', 6),
       ('Chicken Breast', 8.99, 'Boneless, skinless chicken breasts, per lb.', 7),
       ('Frozen Mixed Berries', 5.99, 'Frozen mixed berries, great for smoothies.', 8),
       ('All-Purpose Cleaner', 3.99, 'Effective household cleaner for various surfaces.', 9),
       ('Shampoo', 4.99, 'Gentle shampoo for all hair types.', 10);
