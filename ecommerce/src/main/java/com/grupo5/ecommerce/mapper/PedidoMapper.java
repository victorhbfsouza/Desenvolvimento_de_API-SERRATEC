/*
 * package com.grupo5.ecommerce.mapper;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component;
 * 
 * import com.grupo5.ecommerce.dto.ItemPedidoDTO; import
 * com.grupo5.ecommerce.dto.PedidoDTO; import
 * com.grupo5.ecommerce.entities.ItemPedido; import
 * com.grupo5.ecommerce.entities.Pedido; import
 * com.grupo5.ecommerce.repositories.ClienteRepository; import
 * com.grupo5.ecommerce.repositories.ItemPedidoRepository;
 * 
 * @Component public class PedidoMapper {
 * 
 * @Autowired private ClienteRepository clienteRepository;
 * 
 * @Autowired private ItemPedidoMapper itemPedidoMapper;
 * 
 * @Autowired private ItemPedidoRepository itemPedidoRepository;
 * 
 * public Pedido toEntity(PedidoDTO pedidoDTO) { Pedido pedido = new Pedido();
 * 
 * pedido.setidPedido(pedidoDTO.getIdPedido());
 * pedido.setDataEntrega(pedidoDTO.getDataEntrega());
 * pedido.setDataEnvio(pedidoDTO.getDataEnvio());
 * pedido.setDataPedido(pedidoDTO.getDataPedido());
 * pedido.setStatus(pedidoDTO.getStatus());
 * pedido.setValorTotal(pedidoDTO.getValorTotal());
 * 
 * if (pedidoDTO.getClienteId() != null) {
 * pedido.setCliente(clienteRepository.findById(pedidoDTO.getClienteId()).orElse
 * (null)); }
 * 
 * if (!pedidoDTO.getItens().isEmpty()) { List<ItemPedido> itemPedidos =
 * pedidoDTO.getItens().stream().map(itemPedidoMapper::toEntity).toList();
 * pedido.setItens(itemPedidos); }
 * 
 * return pedido; }
 * 
 * public PedidoDTO toDTO(Pedido pedido) { PedidoDTO dto = new PedidoDTO(); if
 * (pedido.getCliente() != null) {
 * dto.setClienteId(pedido.getCliente().getIdCliente()); }
 * 
 * dto.setDataEntrega(pedido.getDataEntrega());
 * dto.setDataEnvio(pedido.getDataEnvio());
 * dto.setDataPedido(pedido.getDataPedido());
 * 
 * // pedido.setItens(itemPedidoRepository.findByPedido(pedido));
 * 
 * List<ItemPedidoDTO> itemPedidoDTOs = pedido.getItens().stream().map(item ->
 * itemPedidoMapper.toDTO(item)) .toList();
 * 
 * dto.setItens(itemPedidoDTOs);
 * 
 * return dto; } }
 */