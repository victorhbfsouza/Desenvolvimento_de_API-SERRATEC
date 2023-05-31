/*
 * package com.grupo5.ecommerce.mapper;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component;
 * 
 * import com.grupo5.ecommerce.dto.ItemPedidoDTO; import
 * com.grupo5.ecommerce.entities.ItemPedido; import
 * com.grupo5.ecommerce.repositories.PedidoRepository; import
 * com.grupo5.ecommerce.repositories.ProdutoRepository;
 * 
 * @Component public class ItemPedidoMapper {
 * 
 * @Autowired private PedidoRepository pedidoRepository;
 * 
 * @Autowired private ProdutoRepository produtoRepository;
 * 
 * public ItemPedido toEntity(ItemPedidoDTO dto) { ItemPedido itemPedido = new
 * ItemPedido();
 * 
 * itemPedido.setIdItemPedido(dto.getIdItemPedido());
 * itemPedido.setPercentualDesconto(dto.getPercentualDesconto());
 * itemPedido.setPrecoVenda(dto.getPrecoVenda());
 * itemPedido.setQuantidade(dto.getQuantidade());
 * itemPedido.setValorBruto(dto.getValorBruto());
 * itemPedido.setValorLiquido(dto.getValorLiquido());
 * itemPedido.setPercentualDesconto(dto.getPercentualDesconto());
 * 
 * if (dto.getPedidoId() != null) {
 * itemPedido.setPedido(pedidoRepository.findById(dto.getPedidoId()).orElse(null
 * )); }
 * 
 * if (dto.getProdutoId() != null) {
 * itemPedido.setProduto(produtoRepository.findById(dto.getProdutoId()).orElse(
 * null)); }
 * 
 * return itemPedido; }
 * 
 * public ItemPedidoDTO toDTO(ItemPedido item) {
 * 
 * ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
 * itemPedidoDTO.setIdItemPedido(item.getIdItemPedido());
 * itemPedidoDTO.setPedidoId(item.getPedido().getIdPedido());
 * itemPedidoDTO.setPercentualDesconto(item.getPercentualDesconto());
 * itemPedidoDTO.setPrecoVenda(item.getPrecoVenda());
 * itemPedidoDTO.setValorBruto(item.getValorBruto());
 * itemPedidoDTO.setValorLiquido(item.getValorLiquido());
 * 
 * return itemPedidoDTO; } }
 */