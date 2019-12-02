package web;

import MiroWidget.ManageWidget;
import MiroWidget.Widget;
import com.sun.tools.javac.comp.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/widget")
public class WebController {

    //private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_ERROR = 400;

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }



//    @GetMapping("{getId}")
//    public ResponseEntity<Todo> getTodo(@PathVariable UUID getId, @RequestBody ManageWidget request) {
//        try {
//            Widget getWidget = request.getWidget(getId);
//            return ResponseEntity.ok(new Todo(UUID.fromString(getWidget.getId().toString()),
//                    getWidget.getId(),
//                    getId.toString()));
//        } catch (IncorrectResultSizeDataAccessException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }



    @GetMapping("/allWidgets")
    public BaseResponse allWidgets(String key, @RequestBody ManageWidget request) {

        final BaseResponse response;

        List<Widget> getAllWidgets = request.getAllWidgets();

        if (getAllWidgets != null) {

//            String itemId = request.getItemId();
//            double discount = request.getDiscount();
            // Process the request
            // ....
            // Return success response to the client.
            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new BaseResponse(ERROR_STATUS, CODE_ERROR);
        }
        return response;
    }
}
