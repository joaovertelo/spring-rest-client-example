package com.devertelo.springrestclientexample.controller;

import lombok.Data;

@Data
public class Endereco {
	private String uf;
	private String complemento;
	private String ddd;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String ibge;
	private String siafi;
	private String gia;
	private String cep;
}