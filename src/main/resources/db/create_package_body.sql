CREATE OR REPLACE PACKAGE BODY pkg_produto AS

    FUNCTION calcular_novo_preco(p_preco NUMBER, p_percentual NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN p_preco + (p_preco * (p_percentual / 100));
    END calcular_novo_preco;

    PROCEDURE atualizar_preco(p_percentual IN NUMBER) IS
    BEGIN
        UPDATE PRODUTO
        SET preco = calcular_novo_preco(preco, p_percentual);
        
        COMMIT;
    END atualizar_preco;

END pkg_produto;