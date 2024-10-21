CREATE DATABASE IF NOT EXISTS CARS;
USE CARS;

CREATE TABLE Incidents (
  IncidentID INT,
  IncidentType VARCHAR(50),
  IncidentDate DATE,
  Location VARCHAR(100),
  Description TEXT,
  Status VARCHAR(50),
  VictimID INT,
  SuspectID INT,
  AgencyID INT,
  PRIMARY KEY (IncidentID)
);

CREATE TABLE Victims (
  VictimID INT,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  DateOfBirth DATE,
  Gender VARCHAR(10),
  ContactInformation VARCHAR(100),
  PRIMARY KEY (VictimID)
);

CREATE TABLE Suspects (
  SuspectID INT,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  DateOfBirth DATE,
  Gender VARCHAR(10),
  ContactInformation VARCHAR(100),
  PRIMARY KEY (SuspectID)
);

CREATE TABLE Law_Enforcement_Agencies (
  AgencyID INT,
  AgencyName VARCHAR(100),
  Jurisdiction VARCHAR(100),
  ContactInformation VARCHAR(100),
  PRIMARY KEY (AgencyID)
);

CREATE TABLE Officers (
  OfficerID INT NOT NULL AUTO_INCREMENT,
  BadgeNo VARCHAR(20) NOT NULL UNIQUE,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL,
  `Rank` VARCHAR(50), -- Backticks used to escape the reserved keyword 'Rank'
  ContactInformation VARCHAR(100),
  AgencyID INT,
  Password VARCHAR(100),
  PRIMARY KEY (OfficerID),
  FOREIGN KEY (AgencyID) REFERENCES Law_Enforcement_Agencies(AgencyID)
);

CREATE TABLE Evidences (
  EvidenceID INT,
  Description TEXT,
  LocationFound VARCHAR(100),
  IncidentID INT,
  PRIMARY KEY (EvidenceID),
  FOREIGN KEY (IncidentID) REFERENCES Incidents(IncidentID)
);

CREATE TABLE Reports (
  ReportID INT,
  IncidentID INT,
  ReportingOfficer INT,
  ReportDate DATE,
  ReportDetails TEXT,
  Status VARCHAR(50),
  PRIMARY KEY (ReportID),
  FOREIGN KEY (IncidentID) REFERENCES Incidents(IncidentID),
  FOREIGN KEY (ReportingOfficer) REFERENCES Officers(OfficerID)
);

CREATE TABLE Cases(
CaseID INT PRIMARY KEY,
CaseDescription VARCHAR(255),
incidentId INT, 
FOREIGN KEY (incidentID) REFERENCES Incidents(IncidentID)
);




INSERT INTO Incidents (IncidentID, IncidentType, IncidentDate, Location, Description, Status, VictimID, SuspectID, AgencyID)
VALUES
(1, 'Robbery', '2024-01-10', 'Main St, Malegaon', 'Armed robbery at a local store.', 'Open', 1, 1, 1),
(2, 'Homicide', '2024-02-15', 'Elm St, Malegaon', 'Suspicious death in an apartment.', 'Under Investigation', 2, 2, 2),
(3, 'Theft', '2024-03-20', 'Oak St, Malegaon', 'Theft of a vehicle from a parking lot.', 'Closed', 3, 3, 3),
(4, 'Assault', '2024-04-25', 'Pine St, Malegaon', 'Physical assault in a bar.', 'Open', 4, 4, 4),
(5, 'Burglary', '2024-05-30', 'Cedar St, Malegaon', 'Burglary in a residential area.', 'Under Investigation', 5, 5, 5),
(6, 'Fraud', '2024-06-05', 'Spruce St, Malegaon', 'Financial fraud involving a local business.', 'Closed', 6, 6, 6),
(7, 'Cyber Crime', '2024-07-10', 'Maple St, Malegaon', 'Unauthorized access to computer data.', 'Open', 7, 7, 7),
(8, 'Narcotics', '2024-08-15', 'Birch St, Malegaon', 'Drug trafficking in a neighborhood.', 'Under Investigation', 8, 8, 8),
(9, 'Arson', '2024-09-20', 'Palm St, Malegaon', 'Intentional fire in a warehouse.', 'Closed', 9, 9, 9),
(10, 'Kidnapping', '2024-10-25', 'Cypress St, Malegaon', 'Abduction of a local resident.', 'Open', 10, 10, 10);

INSERT INTO Victims (VictimID, FirstName, LastName, DateOfBirth, Gender, ContactInformation)
VALUES
(1, 'John', 'Doe', '1985-06-15', 'Male', '123 Main St, Malegaon, 555-1234'),
(2, 'Jane', 'Smith', '1990-04-20', 'Female', '456 Elm St, Malegaon, 555-5678'),
(3, 'Robert', 'Johnson', '1982-11-12', 'Male', '789 Oak St, Malegaon, 555-8765'),
(4, 'Lisa', 'Brown', '1995-02-22', 'Female', '321 Pine St, Malegaon, 555-2345'),
(5, 'Michael', 'Davis', '1978-09-18', 'Male', '654 Cedar St, Malegaon, 555-3456'),
(6, 'Mary', 'Garcia', '1987-03-10', 'Female', '987 Spruce St, Malegaon, 555-4567'),
(7, 'David', 'Martinez', '1993-05-30', 'Male', '147 Maple St, Malegaon, 555-5678'),
(8, 'Sarah', 'Wilson', '1991-08-25', 'Female', '258 Birch St, Malegaon, 555-6789'),
(9, 'James', 'Lopez', '1984-12-14', 'Male', '369 Palm St, Malegaon, 555-7890'),
(10, 'Laura', 'Clark', '1996-07-07', 'Female', '147 Cypress St, Malegaon, 555-8901');


INSERT INTO Suspects (SuspectID, FirstName, LastName, DateOfBirth, Gender, ContactInformation)
VALUES
(1, 'Andrew', 'Taylor', '1975-05-10', 'Male', '23 Lake Rd, Malegaon, 555-0001'),
(2, 'Anna', 'Williams', '1989-07-19', 'Female', '45 River St, Malegaon, 555-0002'),
(3, 'Brian', 'Miller', '1983-08-22', 'Male', '67 Forest Ave, Malegaon, 555-0003'),
(4, 'Emma', 'Moore', '1992-12-05', 'Female', '89 Hill Dr, Malegaon, 555-0004'),
(5, 'Charlie', 'Taylor', '1987-09-09', 'Male', '21 Valley Ln, Malegaon, 555-0005'),
(6, 'Sophia', 'White', '1981-11-13', 'Female', '43 Meadow St, Malegaon, 555-0006'),
(7, 'Jack', 'Lee', '1979-01-31', 'Male', '65 Grove Rd, Malegaon, 555-0007'),
(8, 'Lucy', 'Harris', '1990-03-18', 'Female', '87 Orchard Ave, Malegaon, 555-0008'),
(9, 'Tom', 'Clark', '1985-04-24', 'Male', '98 Garden St, Malegaon, 555-0009'),
(10, 'Zoe', 'Nelson', '1993-06-27', 'Female', '12 Mountain Rd, Malegaon, 555-0010');


INSERT INTO Law_Enforcement_Agencies (AgencyID, AgencyName, Jurisdiction, ContactInformation)
VALUES
(1, 'Malegaon Police Department', 'Malegaon', '999 Main St, Malegaon, 555-9001'),
(2, 'Crime Investigation Bureau', 'Malegaon', '888 Elm St, Malegaon, 555-9002'),
(3, 'Special Task Force', 'Malegaon', '777 Oak St, Malegaon, 555-9003'),
(4, 'Anti-Narcotics Squad', 'Malegaon', '666 Pine St, Malegaon, 555-9004'),
(5, 'Cyber Crime Unit', 'Malegaon', '555 Cedar St, Malegaon, 555-9005'),
(6, 'Traffic Control Department', 'Malegaon', '444 Spruce St, Malegaon, 555-9006'),
(7, 'Fraud Investigation Department', 'Malegaon', '333 Maple St, Malegaon, 555-9007'),
(8, 'Emergency Response Team', 'Malegaon', '222 Birch St, Malegaon, 555-9008'),
(9, 'Homicide Division', 'Malegaon', '111 Palm St, Malegaon, 555-9009'),
(10, 'Security Enforcement Agency', 'Malegaon', '000 Cypress St, Malegaon, 555-9010');


INSERT INTO Officers (OfficerID, BadgeNo, FirstName, LastName, `Rank`, ContactInformation, AgencyID, Password)
VALUES
(1, 'PD12345', 'Alice', 'Johnson', 'Inspector', '321 Main St, Malegaon, 555-1010', 1, 'password123'),
(2, 'PD23456', 'Bob', 'Smith', 'Sergeant', '432 Elm St, Malegaon, 555-1020', 2, 'password234'),
(3, 'PD34567', 'Charlie', 'Brown', 'Constable', '543 Oak St, Malegaon, 555-1030', 3, 'password345'),
(4, 'PD45678', 'David', 'Williams', 'Detective', '654 Pine St, Malegaon, 555-1040', 4, 'password456'),
(5, 'PD56789', 'Eve', 'Davis', 'Chief', '765 Cedar St, Malegaon, 555-1050', 5, 'password567'),
(6, 'PD67890', 'Frank', 'Martinez', 'Officer', '876 Spruce St, Malegaon, 555-1060', 6, 'password678'),
(7, 'PD78901', 'Grace', 'Garcia', 'Captain', '987 Maple St, Malegaon, 555-1070', 7, 'password789'),
(8, 'PD89012', 'Hank', 'Moore', 'Lieutenant', '198 Birch St, Malegaon, 555-1080', 8, 'password890'),
(9, 'PD90123', 'Ivy', 'Taylor', 'Deputy', '298 Palm St, Malegaon, 555-1090', 9, 'password901'),
(10, 'PD01234', 'Jack', 'Wilson', 'Patrol', '398 Cypress St, Malegaon, 555-1100', 10, 'password012');



INSERT INTO Evidences (EvidenceID, Description, LocationFound, IncidentID)
VALUES
(1, 'Fingerprint on weapon', 'Main St Store', 1),
(2, 'Blood samples', 'Elm St Apartment', 2),
(3, 'CCTV footage', 'Oak St Parking Lot', 3),
(4, 'Witness statement', 'Pine St Bar', 4),
(5, 'Stolen items', 'Cedar St House', 5),
(6, 'Bank transaction records', 'Spruce St Business', 6),
(7, 'Hacked computer logs', 'Maple St Office', 7),
(8, 'Seized drugs', 'Birch St Neighborhood', 8),
(9, 'Gasoline can', 'Palm St Warehouse', 9),
(10, 'Ransom note', 'Cypress St Location', 10);


INSERT INTO Reports (ReportID, IncidentID, ReportingOfficer, ReportDate, ReportDetails, Status)
VALUES
(1, 1, 1, '2024-01-11', 'Initial report of armed robbery with two suspects.', 'Draft'),
(2, 2, 2, '2024-02-16', 'Investigative report on suspicious death.', 'Finalized'),
(3, 3, 3, '2024-03-21', 'Theft case closed with suspect in custody.', 'Finalized'),
(4, 4, 4, '2024-04-26', 'Assault incident involving multiple witnesses.', 'Draft'),
(5, 5, 5, '2024-05-31', 'Burglary report filed with evidence collected.', 'Draft'),
(6, 6, 6, '2024-06-06', 'Financial fraud investigation concluded.', 'Finalized'),
(7, 7, 7, '2024-07-11', 'Cybercrime case under digital forensics.', 'Draft'),
(8, 8, 8, '2024-08-16', 'Narcotics operation in progress.', 'Draft'),
(9, 9, 9, '2024-09-21', 'Arson case investigated with suspect detained.', 'Finalized'),
(10, 10, 10, '2024-10-26', 'Kidnapping report with evidence being analyzed.', 'Draft');


INSERT INTO Cases (CaseID, CaseDescription, incidentId)
VALUES
(1, 'Robbery case involving armed suspects.', 1),
(2, 'Homicide investigation under progress.', 2),
(3, 'Vehicle theft case closed with arrest.', 3),
(4, 'Assault case with multiple witnesses.', 4),
(5, 'Residential burglary case ongoing.', 5),
(6, 'Fraud case involving financial transactions.', 6),
(7, 'Cybercrime case related to unauthorized access.', 7),
(8, 'Drug trafficking case under narcotics squad.', 8),
(9, 'Arson case closed with suspect detained.', 9),
(10, 'Kidnapping case under investigation.', 10);

select * from Cases;

ALTER TABLE Officers DROP COLUMN password;

SELECT * FROM OFFICERS;


