TRANSFORMAÇÕES PARA HTML

FREQ 2 17/18

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method = "html" indent = "yes"/>
	<xsl:template match = "escola">
	<html>
		<body>
			<h1>Responsáveis de Coimbra</h1>
			<ul>
				<xsl:for-each select = "registo"/>
				<xsl:sort select = "responsavel"/>
				<xsl:if test = "local = 'Coimbra'"/>
				<li>Nome do Responsavel:<xsl:value-of select = "responsavel"></li>
				<ul>	
					<xsl:apply-templates select = "alunos/aluno"> //XPath
					<xsl:sort select = "@nome"/> //Atributo do aluno
					</xsl:apply-templates>
				</ul>
				</xsl:if>
				</xsl:for-each>
			</ul>
		</body>
	</html>
	<xsl:template>
	<xsl:template match = "alunos/aluno">
		<li>
		Nome do aluno:<xsl:value-of select = "@alunos"/>
		</li>
	</xsl:template>
</xsl:stylesheet>

EXAME NORMAL 17/18

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
 <xsl:output method ="html" indent = "yes">
	
	<xsl:templates match = "livraria">
	<html>
		<body>
			<h1> Lista de livros Novos de 2017 </h1>
				<ul>
					<xsl:apply-templates select ="novos/livros">
						<xsl:sort select ="titulo">
					</xsl:apply-templates>
				</ul>
			<h1> Lista de livros Usados de 2017 </h1> 
				<ul>
					<xsl:apply-templates select ="usados/livros">
						<xsl:sort select ="titulo">
					</xsl:apply-templates>
				</ul>
	</xsl:templates>		
		<xsl:template match ="novos/livros">
			<xsl:if test="@ano=2017">
				<li> <xsl:value-of select = "//titulo"> tem <xsl:value-of select = "count(//lista_autores/aut)"> autor(es) </li> 
			</xsl:if>
		</xsl:template>	
		<xsl:template match ="usados/livros">
			<xsl:if test="@ano=2017">
				<li> <xsl:value-of select = "//titulo"> tem <xsl:value-of select = "count(//lista_autores/aut)"> autor(es) </li> 
			</xsl:if>
		</xsl:template>	
</xsl:stylesheet>