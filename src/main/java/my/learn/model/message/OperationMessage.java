package my.learn.model.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import my.learn.constatnts.Constants;
import my.learn.model.Operation;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class OperationMessage implements Message {

    private final String filePath;
    @Getter
    private final List<Operation> operations = Constants.operations;
    private final String delimiter;


    @Override
    public String getMessage() {
        String file;
        if (filePath == null) {
            file = "Не выбран";
        } else {
            file = filePath;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append("\n");
        sb.append("Текущий файл: ").append(file).append("\n");
        sb.append(delimiter).append("\n");
        for (Operation operation : operations) {
            sb.append(operation).append("\n");
        }
        sb.append(delimiter).append("\n");
        return sb.toString();
    }

    @Override
    public String getData() {
        return filePath;
    }
}

