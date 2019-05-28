-- dit script vult de OV-chipkaart DB met gegevens
-- er worden minimaal 5 records per tabel aangemaakt.

insert into REIZIGER 
(reizigerID, voorletters, tussenvoegsel, achternaam,gebortedatum)
values (1, 'G', 'van', 'Rijn', To_date('17-09-2002','dd-mm-yyyy')); 
insert into REIZIGER 
(reizigerID, voorletters, tussenvoegsel, achternaam,gebortedatum)
values (2, 'B', 'van', 'Rijn', To_date('22-10-2002','dd-mm-yyyy')); 
insert into REIZIGER 
(reizigerID, voorletters, tussenvoegsel, achternaam,gebortedatum)
values (3, 'H', null, 'Lubben', To_date('11-08-1998','dd-mm-yyyy')); 
insert into REIZIGER 
(reizigerID, voorletters, tussenvoegsel, achternaam,gebortedatum)
values (4, 'F', null, 'Memari', To_date('03-12-2002','dd-mm-yyyy')); 
insert into REIZIGER 
(reizigerID, voorletters, tussenvoegsel, achternaam,gebortedatum)
values (5, 'G', null, 'Piccardo', To_date('03-12-2002','dd-mm-yyyy')); 

insert into OV_Chipkaart 
(kaartNummer, geldigTot, klasse, saldo, reizigerID)
values (35283, To_date('31-05-2018','dd-mm-yyyy'), 2, 25.50, 2);  
insert into OV_Chipkaart 
(kaartNummer, geldigTot, klasse, saldo, reizigerID)
values (46392, To_date('31-05-2017','dd-mm-yyyy'), 2, 5.50, 2);  
insert into OV_Chipkaart 
(kaartNummer, geldigTot, klasse, saldo, reizigerID)
values (57401, To_date('31-05-2015','dd-mm-yyyy'), 2, 0.0, 2);  
insert into OV_Chipkaart 
(kaartNummer, geldigTot, klasse, saldo, reizigerID)
values (68514, To_date('31-03-2020','dd-mm-yyyy'), 1, 2.50, 3);  
insert into OV_Chipkaart 
(kaartNummer, geldigTot, klasse, saldo, reizigerID)
values (79625, To_date('31-01-2020','dd-mm-yyyy'), 1, 25.50, 4);  
insert into OV_Chipkaart 
(kaartNummer, geldigTot, klasse, saldo, reizigerID)
values (90537, To_date('31-12-2019','dd-mm-yyyy'), 2, 20.0, 5);  
insert into OV_Chipkaart 
(kaartNummer, geldigTot, klasse, saldo, reizigerID)
values (18326, To_date('31-12-2017','dd-mm-yyyy'), 2, 0.0, 5);  

insert into ADRES
(adresID, postcode, straat, huisnummer, woonplaats, reizigerID)
values (1, '3511 LX', 'Visschersplein ', '37', 'Utrecht', 1); 
insert into ADRES
(adresID, postcode, straat, huisnummer, woonplaats, reizigerID)
values (2, '3521 AL', 'Jaarbeursplein', '6A', 'Utrecht', 2); 
insert into ADRES
(adresID, postcode, straat, huisnummer, woonplaats, reizigerID)
values (3, '1791 AV', 'Emmalaan', '66D', 'Den Burg', 2); 
insert into ADRES
(adresID, postcode, straat, huisnummer, woonplaats, reizigerID)
values (4, '6707 AA', 'Stadsbrink', '375', 'Wageningen', 3); 
insert into ADRES
(adresID, postcode, straat, huisnummer, woonplaats, reizigerID)
values (5, '3817 CH', 'Arnhemseweg', '4', 'Amersfoort', 4); 
insert into ADRES
(adresID, postcode, straat, huisnummer, woonplaats, reizigerID)
values (6, '3572 WP', 'Vermeulenstraat ', '22', 'Utrecht', 5); 

Insert into PRODUCT
(productNummer, productNaam, beschrijving, prijs)
values(1, 'Dagkaart 2e klas', 'Een hele dag onbeperkt reizen met de trein.', 50.60 ); 
Insert into PRODUCT
(productNummer, productNaam, beschrijving, prijs)
values(2, 'Dagkaart fiets', 'Uw fiets mee in de trein, 1 dag geldig in Nederland.Uw fiets mee in de trein, 1 dag geldig in Nederland.', 6.20 ); 
Insert into PRODUCT
(productNummer, productNaam, beschrijving, prijs)
values(3, 'Dal Voordeel 40%', '40% korting buiten de spits en in het weekeind.', 50.0 ); 
Insert into PRODUCT
(productNummer, productNaam, beschrijving, prijs)
values(4, 'Amsterdam Travel Ticket', 'Onbeperkt reizen door Amsterdam.', 26.0 ); 
Insert into PRODUCT
(productNummer, productNaam, beschrijving, prijs)
values(5, 'Railrunner', 'Voordelig reizen voor kinderen.', 2.50 ); 
Insert into PRODUCT
(productNummer, productNaam, beschrijving, prijs)
values(6, 'Studentenreisproduct', 'Gratis of met korting reizen als je studeert', 0.0 ); 

Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (1, 35283, 3, 'actief', To_Date('31-05-2017','dd-mm-yyyy')); 
Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (2, 35283, 1, 'gekocht', To_Date('05-04-2018','dd-mm-yyyy')); 
Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (3, 35283, 2, 'gekocht', To_Date('05-04-2018','dd-mm-yyyy')); 
Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (4, 46392, 3, 'verlopen', To_Date('31-05-2017','dd-mm-yyyy')); 
Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (5, 68514, 6, 'actief', To_Date('01-04-2018','dd-mm-yyyy')); 
Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (6, 79625, 6, 'actief', To_Date('01-02-2018','dd-mm-yyyy')); 
Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (7, 90537, 3, 'actief', To_Date('01-02-2018','dd-mm-yyyy')); 
Insert into OV_Chipkaart_Product
(ovproductID, kaartnummer, productnummer, reisproductStatus, lastUpdate) 
values (8, 90537, 2, 'gekocht', To_Date('14-04-2018','dd-mm-yyyy')); 
commit;