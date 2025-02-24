CREATE OR REPLACE PACKAGE pkg_produto AS
    PROCEDURE atualizar_preco(p_percentual IN NUMBER);
    FUNCTION calcular_novo_preco(p_preco NUMBER, p_percentual NUMBER) RETURN NUMBER;
END pkg_produto;