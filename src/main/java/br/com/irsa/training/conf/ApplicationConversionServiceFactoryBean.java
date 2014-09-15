package br.com.irsa.training.conf;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;
import br.com.irsa.training.model.Telefone;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value="applicationConversionService")
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {
	 
 
    @Override
    protected void installFormatters(FormatterRegistry registry) {
        super.installFormatters(registry);
        registry.addConverter(getJSONCollectionToListConverter());
    }
 
    public Converter<String, List<Telefone>> getJSONCollectionToListConverter() {
        return new Converter<String, List<Telefone>>() {
 
            @Override
            public List<Telefone> convert(String source) {
                ObjectMapper mapper = new ObjectMapper();
                List<Telefone> myTypeList = null;
                try {
                    myTypeList = mapper.readValue(source, new TypeReference<List<Telefone>>() {});
                } catch (Exception e) {
                }
                return myTypeList;
            }
        };
    }
}
