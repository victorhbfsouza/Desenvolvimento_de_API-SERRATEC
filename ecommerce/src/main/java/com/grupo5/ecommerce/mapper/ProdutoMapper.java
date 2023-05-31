/*
 * package com.grupo5.ecommerce.mapper;
 * 
 * import org.springframework.stereotype.Component;
 * 
 * import com.grupo5.ecommerce.dto.ProdutoDTO; import
 * com.grupo5.ecommerce.entities.Produto;
 * 
 * @Component public class ProdutoMapper {
 * 
 * public Produto toEntity(ProdutoDTO produtoDTO) { Produto produto = new
 * Produto(); produto.setNome(produtoDTO.getNome());
 * produto.setDescricao(produtoDTO.getDescricao());
 * produto.setQtdEstoque(produtoDTO.getQtdEstoque());
 * produto.setValorUnitario(produtoDTO.getValorUnitario());
 * 
 * // Outros atributos
 * 
 * return produto; }
 * 
 * public ProdutoDTO toDTO(Produto produto) { ProdutoDTO dto = new ProdutoDTO();
 * dto.setNome(produto.getNome()); dto.setQtdEstoque(produto.getQtdEstoque());
 * dto.setDataCadastro(produto.getDataCadastro());
 * dto.setValorUnitario(produto.getValorUnitario());
 * 
 * // Outros atributos
 * 
 * return dto; }
 * 
 * }
 */