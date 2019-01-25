--liquibase formatted sql

--changeset akif.khan:1 runOnChange:false

CREATE TABLE `EventsTransition` (
  `name` varchar(255) NOT NULL,
  `stateMachineId` varchar(64) NOT NULL,
  `executionVersion` smallint(5) unsigned NOT NULL,
  `eventData` mediumblob,
  `eventSource` varchar(100) DEFAULT NULL,
  `validity` enum('yes','no') DEFAULT NULL,
  `createdAt` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `updatedAt` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`stateMachineId`,`name`,`executionVersion`),
  CONSTRAINT `FK_sm_eventsTransition` FOREIGN KEY (`stateMachineId`) REFERENCES `StateMachines` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--rollback drop table EventsTrasition;