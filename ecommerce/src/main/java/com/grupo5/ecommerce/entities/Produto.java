package com.grupo5.ecommerce.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idProduto"
        )
@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer idProduto;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "qtd_estoque")
	private Integer qtdEstoque;
	
	@Column(name = "data_cadastro")
	private Instant dataCadastro;
	
	@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;
	
	@Column(name = "imagem")
	private byte[] imagem;
	private byte[] imagemDados; 
    private String imagemNome; 
    private String imagemTipo;
	
	@ManyToOne 
	@JoinColumn(name = "id_categoria", 
					referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto")
	private Set<ItemPedido> pedidos = new HashSet<>();

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<ItemPedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<ItemPedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public byte[] getImagemDados() {
		return imagemDados;
	}

	public void setImagemDados(byte[] imagemDados) {
		this.imagemDados = imagemDados;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemTipo() {
		return imagemTipo;
	}

	public void setImagemTipo(String imagemTipo) {
		this.imagemTipo = imagemTipo;
	}
	
	public void AddTime() {
		dataCadastro = Instant.now();
	}

	@Override
    public String toString() {
        return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", qtdEstoque="
                + qtdEstoque + ", dataCadastro=" + dataCadastro + ", valorUnitario=" + valorUnitario + ", imagemDados="
                + Arrays.toString(imagemDados) + ", imagemNome=" + imagemNome + ", imagemTipo=" + imagemTipo
                + ", categoria=" + categoria + ", pedidos=" + pedidos + "]";
    }
	
}
