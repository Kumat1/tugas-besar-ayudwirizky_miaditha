-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2017 at 11:31 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_buku`
--

CREATE TABLE `tb_buku` (
  `id_buku` char(4) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `isbn` varchar(100) NOT NULL,
  `pengarang` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `tahun_buku` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_buku`
--

INSERT INTO `tb_buku` (`id_buku`, `judul_buku`, `isbn`, `pengarang`, `penerbit`, `tahun_buku`) VALUES
('B001', 'Buku Pintar PHP MySQL', '97979431433', 'Zuhroh Nilakandi', 'MediaKIta', 2012),
('B002', 'Struktur Data dan Pemrograman dengan Pascal', '9797314464', 'Sarifah Farrah fadilla', 'Ipeh', 2004),
('B003', 'Belajar Pemrograman dengan Bahasa C++ dan Java', '9791153078', 'Virliansi Adrisa Utami', 'Informatika', 2017),
('B004', 'Pemrograman Internet', '9798771664', 'Rizki Sari Dewi', 'MediaKom', 2002),
('B005', 'Tangkas Coding', '9798767655342', 'Rizka Amaliyah', 'Amel', 2016),
('B006', 'Go! Blog', '9791167176', 'Putri Ramadannia', 'PutputMedia', 2008),
('B007', 'Dasar dasar Database', '', 'Shifani', 'faniii', 2012),
('B008', 'Pemrograman Java', '151402006', 'Ayu Dwi Rizky', 'Airlangga', 2017);

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_peminjaman`
--

CREATE TABLE `tb_detail_peminjaman` (
  `id_detail_peminjaman` char(4) NOT NULL,
  `id_buku` varchar(100) NOT NULL,
  `id_peminjaman` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detail_peminjaman`
--

INSERT INTO `tb_detail_peminjaman` (`id_detail_peminjaman`, `id_buku`, `id_peminjaman`) VALUES
('D001', 'B002', 'J001'),
('D002', 'B003', 'J001'),
('D003', 'B004', 'J002'),
('D004', 'B003', 'J002'),
('D005', 'B001', 'J005'),
('D006', 'B001', 'J006'),
('D008', 'B001', 'J006'),
('D009', 'B002', 'J007');

-- --------------------------------------------------------

--
-- Table structure for table `tb_karyawan`
--

CREATE TABLE `tb_karyawan` (
  `id_karyawan` char(4) NOT NULL,
  `nama_karyawan` varchar(100) NOT NULL,
  `alamat_karyawan` varchar(100) NOT NULL,
  `hp_karyawan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_karyawan`
--

INSERT INTO `tb_karyawan` (`id_karyawan`, `nama_karyawan`, `alamat_karyawan`, `hp_karyawan`) VALUES
('K001', 'Kidunk', 'dimana-mana', '08174192940'),
('K002', 'Ipeh', 'Berandan', '089765654543'),
('K003', 'Zudizud', 'maryland', '087123234345');

-- --------------------------------------------------------

--
-- Table structure for table `tb_member`
--

CREATE TABLE `tb_member` (
  `id_member` char(4) NOT NULL,
  `nama_member` varchar(100) NOT NULL,
  `alamat_member` varchar(100) NOT NULL,
  `hp_member` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_member`
--

INSERT INTO `tb_member` (`id_member`, `nama_member`, `alamat_member`, `hp_member`) VALUES
('M001', 'Sarifah Farah', 'jl.jamin ginting', '089786453241'),
('M002', 'Mia Rahma', 'jl.halat', '087675345213'),
('M003', 'Virliansi', 'Marendal', '086754565555'),
('M004', 'Putri', 'jl.Seksama', '085277016543');

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE `tb_peminjaman` (
  `id_peminjaman` char(4) NOT NULL,
  `id_member` char(4) DEFAULT NULL,
  `id_karyawan` char(4) DEFAULT NULL,
  `jumlah_buku` int(11) DEFAULT NULL,
  `tanggal_peminjaman` date DEFAULT NULL,
  `tanggal_pengembalian` date DEFAULT NULL,
  `tanggal_deadline_pengembalian` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_peminjaman`
--

INSERT INTO `tb_peminjaman` (`id_peminjaman`, `id_member`, `id_karyawan`, `jumlah_buku`, `tanggal_peminjaman`, `tanggal_pengembalian`, `tanggal_deadline_pengembalian`) VALUES
('J001', 'M001', 'K002', 2, '2012-05-10', '2012-09-15', '2012-05-17'),
('J002', 'M002', 'K001', 2, '2012-10-12', '2012-10-15', '2010-10-24'),
('J003', 'M003', 'K002', 2, '2012-12-11', '2017-06-10', '2012-12-20'),
('J004', 'M003', 'K003', 2, '2012-10-13', '2017-06-10', '2012-10-20'),
('J005', 'M001', 'K001', 1, '2012-09-12', '2012-09-15', '2012-09-19'),
('J006', 'M002', 'K001', 2, '2012-10-13', '2012-10-15', '2012-10-20'),
('J007', 'M001', 'K003', 1, '2010-10-12', '0000-00-00', '2010-10-16'),
('P1', 'M003', 'K002', 2, '2017-06-10', '2017-06-10', '2017-06-15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_buku`
--
ALTER TABLE `tb_buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `tb_detail_peminjaman`
--
ALTER TABLE `tb_detail_peminjaman`
  ADD PRIMARY KEY (`id_detail_peminjaman`),
  ADD KEY `fk_id_buku` (`id_buku`),
  ADD KEY `fk_id_peminjaman` (`id_peminjaman`);

--
-- Indexes for table `tb_karyawan`
--
ALTER TABLE `tb_karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `tb_member`
--
ALTER TABLE `tb_member`
  ADD PRIMARY KEY (`id_member`);

--
-- Indexes for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `fk_id_member` (`id_member`),
  ADD KEY `fk_id_karyawan` (`id_karyawan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_detail_peminjaman`
--
ALTER TABLE `tb_detail_peminjaman`
  ADD CONSTRAINT `FK_tb_detail_peminjaman_with_tb_buku` FOREIGN KEY (`id_buku`) REFERENCES `tb_buku` (`id_buku`),
  ADD CONSTRAINT `FK_tb_detail_peminjaman_with_tb_peminjaman` FOREIGN KEY (`id_peminjaman`) REFERENCES `tb_peminjaman` (`id_peminjaman`);

--
-- Constraints for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD CONSTRAINT `FK_tb_peminjaman_with_tb_karyawan` FOREIGN KEY (`id_karyawan`) REFERENCES `tb_karyawan` (`id_karyawan`),
  ADD CONSTRAINT `FK_tb_peminjaman_with_tb_member` FOREIGN KEY (`id_member`) REFERENCES `tb_member` (`id_member`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
