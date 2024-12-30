﻿
CREATE DATABASE TRAINTICKETMANAGEMENT;
USE TRAINTICKETMANAGEMENT;
--=============================================================================
CREATE TABLE TAIKHOAN (
	TENDN NVARCHAR(20) NOT NULL,
	MATKHAU NVARCHAR(20),
	ROLE NVARCHAR(30),
	TINHTRANG BIT,
	CONSTRAINT PK_TAIKHOAN PRIMARY KEY(TENDN)
)
--============================================================================
CREATE TABLE KHACHHANG (
	MAKH INT IDENTITY(101,1) NOT NULL CONSTRAINT PK_KH PRIMARY KEY,
	TENDN NVARCHAR(20),--FK
	TENKH NVARCHAR(30) NOT NULL,
	VI INT,
	DIACHI NVARCHAR(100),
	GIOITINH NVARCHAR(3) ,
	SDT VARCHAR(20) NOT NULL,
	NGSINH DATE
	)
Alter table KHACHHANG
ADD UNIQUE(TENDN)
--=========================================================================
CREATE TABLE NHANVIEN (
	MANV INT IDENTITY(201,1) NOT NULL CONSTRAINT PK_NV PRIMARY KEY(MANV),
	TENDN NVARCHAR(20), --FK
	TENNV NVARCHAR(30) NOT NULL,
	DIACHI NVARCHAR(100) NOT NULL,
	NGSINH Date NOT NULL,
	SDT NVARCHAR(20) NOT NULL
	)
Alter table NHANVIEN
ADD UNIQUE(TENDN)
--========================================================================
CREATE TABLE TAU(
	MATAU INT IDENTITY(301,1) NOT NULL CONSTRAINT PK_TAU PRIMARY KEY(MATAU),
	TENTAU NVARCHAR(30) NOT NULL,
	HANGSX NVARCHAR(30) NOT NULL,
	SOGHEL1 INT NOT NULL,
	SOGHEL2 INT NOT NULL,
	TONGSOGHE INT NOT NULL,
	TINHTRANG BIT
)

--========================================================
CREATE TABLE TUYENTAU(
	MATUYEN INT IDENTITY(401,1) NOT NULL,
	TENGADI NVARCHAR(30) NOT NULL,
	TENGADEN NVARCHAR(30) NOT NULL,
	CONSTRAINT PK_TT PRIMARY KEY(MATUYEN)
)
--============================================================

--==================================================================
CREATE TABLE CHUYENTAU(
	MACHUYEN INT IDENTITY(501,1) NOT NULL,
	MATUYEN INT,--FK
	MATAU INT,--FK
	NGAYKHOIHANH Date,
	GIOKHOIHANH NVARCHAR(20),
	CONSTRAINT PK_CT PRIMARY KEY(MACHUYEN)
)
--=============================================================================
CREATE TABLE HOADON(
	MAHD INT IDENTITY(601,1) NOT NULL,
	MAKH INT,--FK
	MAVE INT,--FK
	NGAYLAP DATE,
	CONSTRAINT PK_HD PRIMARY KEY(MAHD)
)

--=========================================================================

CREATE TABLE VE(
	MAVE INT IDENTITY(701,1) NOT NULL,
	MACHUYEN INT,--FK
	TIENVE INT,
	LOAIGHE NVARCHAR(10),
	SOLUONG INT,
	CONSTRAINT PK_VE PRIMARY KEY(MAVE)
	)
--==============================================================================
--TAO RANG BUOC KHOA NGOAI
ALTER TABLE KHACHHANG ADD
	CONSTRAINT FK_KH_TENDN FOREIGN KEY (TENDN) REFERENCES TAIKHOAN (TENDN)

ALTER TABLE NHANVIEN ADD
	CONSTRAINT FK_NV_TENDN FOREIGN KEY (TENDN) REFERENCES TAIKHOAN (TENDN)

ALTER TABLE CHUYENTAU ADD
	CONSTRAINT FK_CT_MATUYEN FOREIGN KEY (MATUYEN) REFERENCES TUYENTAU (MATUYEN),
	CONSTRAINT FK_CT_MATAU FOREIGN KEY (MATAU) REFERENCES TAU (MATAU)

ALTER TABLE HOADON ADD
	CONSTRAINT FK_HD_MAKH FOREIGN KEY (MAKH) REFERENCES KHACHHANG (MAKH),
	CONSTRAINT FK_HD_MAVE FOREIGN KEY (MAVE) REFERENCES VE (MAVE)

ALTER TABLE VE ADD
	CONSTRAINT FK_VE_MACT FOREIGN KEY (MACHUYEN) REFERENCES CHUYENTAU (MACHUYEN)
--====================================================================
--THEM DU LIEU
set dateformat dmy

create trigger hd on HOADON after insert as
begin
	update VE
	set SoLuong = Soluong -1
	from VE
	Join inserted on VE.MAVE = inserted.MAVE
end
---------------------TAU
INSERT INTO TAU(TENTAU,HANGSX, SOGHEL1, SOGHEL2, TONGSOGHE, TINHTRANG) VALUES (N'Metro số 1',N'diesel DMU',120,150,270,1)
INSERT INTO TAU(TENTAU,HANGSX, SOGHEL1, SOGHEL2, TONGSOGHE, TINHTRANG) VALUES (N'Metro số 2',N'diesel DMU',50,150,200,1)
INSERT INTO TAU(TENTAU,HANGSX, SOGHEL1, SOGHEL2, TONGSOGHE, TINHTRANG) VALUES (N'Metro số 3',N'diesel DMU',130,150,280,1)
INSERT INTO TAU(TENTAU,HANGSX, SOGHEL1, SOGHEL2, TONGSOGHE, TINHTRANG) VALUES (N'Metro số 4',N'Kiha',120,150,270,0)
INSERT INTO TAU(TENTAU,HANGSX, SOGHEL1, SOGHEL2, TONGSOGHE, TINHTRANG) VALUES (N'Metro số 5',N'Kiha',100,150,250,0)

-------------TUYEN TAU
INSERT INTO TUYENTAU(TENGADI, TENGADEN) VALUES (N'Bến Thành',N'Suối Tiên')--R
INSERT INTO TUYENTAU(TENGADI, TENGADEN) VALUES (N'Bến Thành',N'Tân Bình')
INSERT INTO TUYENTAU(TENGADI, TENGADEN) VALUES (N'Hàng Xanh',N'Cầu Sài Gòn')
INSERT INTO TUYENTAU(TENGADI, TENGADEN) VALUES (N'Phú Lâm', N'Bến Thành')
INSERT INTO TUYENTAU(TENGADI, TENGADEN) VALUES (N'Cầu Sài Gòn',N'Suối Tiên')

------------CHUYEN TAU
INSERT INTO CHUYENTAU(MATUYEN,MATAU, NGAYKHOIHANH,GIOKHOIHANH) VALUES ('401','301','21/04/2023','12:00')
INSERT INTO CHUYENTAU(MATUYEN,MATAU, NGAYKHOIHANH,GIOKHOIHANH) VALUES ('403','302','25/02/2023','12:00')
INSERT INTO CHUYENTAU(MATUYEN,MATAU, NGAYKHOIHANH,GIOKHOIHANH) VALUES ('403','303','24/02/2023','16:00')
INSERT INTO CHUYENTAU(MATUYEN,MATAU, NGAYKHOIHANH,GIOKHOIHANH) VALUES ('404','304','27/02/2023','10:00')
INSERT INTO CHUYENTAU(MATUYEN,MATAU, NGAYKHOIHANH,GIOKHOIHANH) VALUES ('405','305','25/02/2023','12:00')
INSERT INTO CHUYENTAU(MATUYEN,MATAU, NGAYKHOIHANH,GIOKHOIHANH) VALUES ('401','301','24/02/2023','16:00')
INSERT INTO CHUYENTAU(MATUYEN,MATAU, NGAYKHOIHANH,GIOKHOIHANH) VALUES ('402','302','27/02/2023','10:00')

------------VE
INSERT INTO VE(MACHUYEN, TIENVE, LOAIGHE, SOLUONG) VALUES ('501',50000,'L1',40)
INSERT INTO VE(MACHUYEN, TIENVE, LOAIGHE, SOLUONG) VALUES ('502',75000,'L2', 35)
INSERT INTO VE(MACHUYEN, TIENVE, LOAIGHE, SOLUONG) VALUES ('503',75000,'L1',40)
INSERT INTO VE(MACHUYEN, TIENVE, LOAIGHE, SOLUONG) VALUES ('504',100000,'L1', 30)
INSERT INTO VE(MACHUYEN, TIENVE, LOAIGHE, SOLUONG) VALUES ('505',100000,'L1', 40)
INSERT INTO VE(MACHUYEN, TIENVE, LOAIGHE, SOLUONG) VALUES ('501',50000,'L2', 40)
INSERT INTO VE(MACHUYEN, TIENVE, LOAIGHE, SOLUONG) VALUES ('502',50000,'L2', 40)

-------------TAI KHOAN
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN101','DN123',N'KHÁCH HÀNG', 0)
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN102','DN123',N'KHÁCH HÀNG', 0)
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN103','DN123',N'KHÁCH HÀNG', 0)
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN104','DN123',N'KHÁCH HÀNG', 0)
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN105','DN123',N'KHÁCH HÀNG', 0)
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN106','DN123',N'NHÂN VIÊN', 0)
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN107','DN123',N'NHÂN VIÊN', 0)
INSERT INTO TAIKHOAN(TENDN,MATKHAU,ROLE, TINHTRANG) VALUES ('DN108','DN123',N'NHÂN VIÊN', 0)

------------KHACH HANG
INSERT INTO KHACHHANG(TENDN,TENKH, VI, DIACHI, GIOITINH, SDT, NGSINH) VALUES ('DN101',N'Nguyễn Văn A',500000, N'209/43 Tôn Thất Thuyết',N'NỮ','0882345122', '27/03/1999')
INSERT INTO KHACHHANG(TENDN,TENKH, VI, DIACHI, GIOITINH, SDT, NGSINH) VALUES ('DN102',N'Nguyễn Văn B',700000, N'35/1P ấp Hưng Lân, Xã Bà Điểm',N'NỮ','0222345111', '27/04/1998')
INSERT INTO KHACHHANG(TENDN,TENKH, VI, DIACHI, GIOITINH, SDT, NGSINH) VALUES ('DN103',N'Nguyễn Văn C',100000, N'304 Lê Quang Sung, P6, Q6',N'NỮ','0916733533', '29/03/1998')
INSERT INTO KHACHHANG(TENDN,TENKH, VI, DIACHI, GIOITINH, SDT, NGSINH) VALUES ('DN104',N'Nguyễn Văn D',200000, N'523/28/2 Lê Văn Khương, KP 5,Hiệp Thành',N'NAM','0145674288', '09/03/1997')
INSERT INTO KHACHHANG(TENDN,TENKH, VI, DIACHI, GIOITINH, SDT, NGSINH) VALUES ('DN105',N'Nguyễn Văn E',1000000, N'30/4 Chiến Lược, khu phố 13, phường Bình Trị Đông',N'NAM','0941675255', '23/03/1997')
INSERT INTO KHACHHANG(TENDN,TENKH, VI, DIACHI, GIOITINH, SDT, NGSINH) VALUES ('DN106',N'Nguyễn Văn F',70000, N'293 Điện Biên Phủ',N'NAM','0814564512', '16/03/1999')

-----------NHAN VIEN
INSERT INTO NHANVIEN(TENDN,TENNV,DIACHI,NGSINH,SDT) VALUES ('DN107',N'Nguyễn Ngọc Hân',N'45 DAKAO,Q1,TPHCM','13/02/2006','0927345678')
INSERT INTO NHANVIEN(TENDN,TENNV,DIACHI,NGSINH,SDT) VALUES ('DN108',N'Lê Thị Phi Yến',N'837 LE HONG PHONG,Q5,TPHCM','10/04/2006','0987567390')

-----------HOA DON

INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (101,'701','04/01/2023')
INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (102,'702','20/02/2023')
INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (103,'703','20/02/2023')
INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (104,'704','25/02/2023')
INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (105,'705','20/02/2023')
INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (106,'706','20/04/2023')
INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (107,'707','03/04/2023')

--==================================================================================
Select * From KHACHHANG
Select * From NHANVIEN
Select * From CHUYENTAU
Select * From TUYENTAU
Select * From TAIKHOAN
Select * From HOADON
Select * From VE
select * from TAIKHOAN


Select TENTAU from TAU where MATAU=305