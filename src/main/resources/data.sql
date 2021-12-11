insert into BEER_CATEGORY
values (1001, 'Ale'),
       (1002, 'Lager'),
       (1003, 'Porter'),
       (1004, 'Stout'),
       (1005, 'Blonde Ale'),
       (1006, 'Brown Ale'),
       (1007, 'IPA (India Pale ALe)'),
       (1008, 'Pilsner'),
       (1009, 'Wheat'),
       (1010, 'Sour Ale');

insert into BEER(ID, NAME, ALCOHOL_LEVEL, PRICE, CATEGORY_ID)
values (101, 'Soproni Óvatos Duhaj IPA', 4.5, 309, 1007),
       (102, 'Kőbányai', 4.3, 219, 1005),
       (103, 'Kronenbourg 1664 Blanc', 5, 365, 1009),
       (104, 'Tuborg', 4.6, 249, 1001),
       (105, 'Faxe Strong', 10, 1679, 1001),
       (106, 'Soproni Óvatos Duhaj Démon', 5.2, 299, 1006);
