USE [libreriaDB]
GO
/****** Object:  User [adminJAVA]    Script Date: 22/09/2021 2:56:34 ******/
CREATE USER [adminJAVA] FOR LOGIN [adminJAVA] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [adminJAVA]
GO
/****** Object:  Table [dbo].[Sucursal]    Script Date: 22/09/2021 2:56:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sucursal](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NULL,
	[descripcion] [nvarchar](50) NULL,
	[estado] [nvarchar](50) NULL,
	[fechaCreacion] [date] NULL,
	[fechaActualizacion] [date] NULL,
 CONSTRAINT [PK_Sucursal1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Sucursal] ON 

INSERT [dbo].[Sucursal] ([id], [nombre], [descripcion], [estado], [fechaCreacion], [fechaActualizacion]) VALUES (1, N'Lima', N'Sede Central', N'Activo', CAST(N'2021-09-22' AS Date), CAST(N'2021-09-22' AS Date))
INSERT [dbo].[Sucursal] ([id], [nombre], [descripcion], [estado], [fechaCreacion], [fechaActualizacion]) VALUES (2, N'Amigos Unidos', N'Sucursal Lima Norte', N'activo', CAST(N'2021-09-22' AS Date), CAST(N'2021-09-22' AS Date))
INSERT [dbo].[Sucursal] ([id], [nombre], [descripcion], [estado], [fechaCreacion], [fechaActualizacion]) VALUES (4, N'Cristianos Unidos', N'Sede Oculta', N'Activo', CAST(N'2021-09-22' AS Date), CAST(N'2021-09-22' AS Date))
SET IDENTITY_INSERT [dbo].[Sucursal] OFF
GO
