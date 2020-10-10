-- adds type transport to table type_transport
INSERT INTO type_transport(name) VALUES('car');
INSERT INTO type_transport (name) VALUES ('motorcycle');

-- adds transport to table transport with type_transport = car;
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'BMV',
  '30000',
  CURRENT_DATE,
  '1'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Mazda',
  '15000',
  CURRENT_DATE,
  '1'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Maserati',
  '50000',
  CURRENT_DATE,
  '1'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Audi',
  '25000',
  CURRENT_DATE,
  '1'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Rover',
  '10000',
  CURRENT_DATE,
  '1'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Porsche',
  '40000',
  CURRENT_DATE,
  '1'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Volvo',
  '23000',
  CURRENT_DATE,
  '1'
);

-- adds transport to table transport with type_transport = motorcycle;
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Suzuki',
  '900',
  CURRENT_DATE,
  '1'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Honda',
  '850',
  CURRENT_DATE,
  '2'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Yamaha',
  '1200',
  CURRENT_DATE,
  '2'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Kawasaki',
  '600',
  CURRENT_DATE,
  '2'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'KTM',
  '8000',
  CURRENT_DATE,
  '2'
);

INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Harley Davidson',
  '10000',
  CURRENT_DATE,
  '2'
);
INSERT INTO transport (name, price, date_create, type_transport_id) VALUES (
  'Ducati',
  '20000',
  CURRENT_DATE,
  '2'
);

-- get all transport (console query SQL)
/*
SELECT T.ID, T.NAME, T.PRICE, T.DATE_CREATE, TT.NAME "TYPE TRANSPORT" FROM TRANSPORT  AS T
INNER JOIN TYPE_TRANSPORT AS TT ON T.TYPE_TRANSPORT_ID = TT.ID
*/

-- get all transport by type motorcycle and price motorcycle > 1000 (console query SQL)
/*
SELECT T.ID, T.NAME, T.PRICE, T.DATE_CREATE, TT.NAME "TYPE TRANSPORT" FROM TRANSPORT  AS T
INNER JOIN TYPE_TRANSPORT AS TT ON T.TYPE_TRANSPORT_ID = TT.ID
WHERE (TT.NAME = 'motorcycle' AND T.PRICE >1000)
*/