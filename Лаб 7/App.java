package com.mycompany.mywebapp;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;



import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {
	private static final String API_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    public void doGet() {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, API_URL);

        try {
            Request response = builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    // Обробка помилки
                    showError("Виникла помилка при отриманні курсів валют.");
                }

                public void onResponseReceived(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        String json = response.getText();
                        
                        JSONArray jsonArray = JSONParser.parseStrict(json).isArray();
                        if (jsonArray != null) {
                            VerticalPanel panel = new VerticalPanel();
                            for (int i = 0; i < jsonArray.size(); i++) {
                                JSONObject currencyObject = jsonArray.get(i).isObject();
                                String currencyName = currencyObject.get("ccy").isString().stringValue();
                                String buy = currencyObject.get("buy").isString().stringValue();
                                String sale = currencyObject.get("sale").isString().stringValue();
                                
                                String messageText = "КУПІВЛЯ " + buy + " ПРОДАЖ " + sale + " НАЗВА ВАЛЮТИ " + currencyName;
                                HTML message = new HTML(messageText);
                                panel.add(message);
								
                            }
                            // Додати панель з курсами валют на сайт
                            RootPanel.get("senddolar").add(panel);
							RootPanel.get("senddolar").addStyleName("text-green");


							
                        } else {
                            showError("Не вдалося розпарсити JSON.");
                        }
                    } else {
                       
                        showError("Отримана відповідь зі статусом: " + response.getStatusCode());
                    }
                }
            });
        } catch (RequestException e) {
     
            showError("Виняток під час виконання запиту: " + e.getMessage());
        }
    }
public void doGoWeater() {
    Frame frame = new Frame("https://www.meteoblue.com/en/weather/widget/three/rivne_ukraine_695594?geoloc=fixed&nocurrent=0&noforecast=0&days=4&tempunit=CELSIUS&windunit=KILOMETER_PER_HOUR&layout=dark ");
    frame.getElement().setAttribute("frameborder", "0");
    frame.getElement().setAttribute("scrolling", "NO");
    frame.getElement().setAttribute("allowtransparency", "true");
    frame.getElement().setAttribute("sandbox", "allow-same-origin allow-scripts allow-popups allow-popups-to-escape-sandbox");
    
    int windowWidth = Window.getClientWidth();
    frame.getElement().getStyle().setWidth(windowWidth, Style.Unit.PX); // Додано ";"
    
    frame.getElement().getStyle().setHeight(591, Style.Unit.PX); // Змінено на 591
    RootPanel.get("weatherContainer").add(frame);
}



    // Метод для відображення повідомлення про помилку на сайті
    private void showError(String message) {
        HTML error = new HTML(message);
        RootPanel.get().add(error);
    }
/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final Button weatherButton = new Button("ОТРИМАТИ ПОГОДУ");
		final Button senddolar = new Button("ОТРИМАТИ КУРС ДОЛАРА");
senddolar.addClickHandler(new ClickHandler() {
    @Override
    public void onClick(ClickEvent event) {
        
        doGet();
       
        senddolar.setEnabled(false);
    }
});
weatherButton.addClickHandler(new ClickHandler() {
    @Override
    public void onClick(ClickEvent event) {
         
        doGoWeater();
       
        weatherButton.setVisible(false);
		
    }
});
RootPanel.get("weatherButton").add(weatherButton);
RootPanel.get("senddolar").add(senddolar);




		final Button sendButton = new Button("Send to Server");
		final TextBox phone = new TextBox();
		phone.setText("Телефон");
		final TextBox name = new TextBox();
		name.setText("CТАСІК");
		final TextBox email = new TextBox();
		email.setText("wjdnwkla.com");
			final TextBox message = new TextBox();
		message.setText("Message");

		final Label errorLabel = new Label();
sendButton.addStyleName("sendButton bg-green-500 px-2 py-2 verflow-hidden whitespace-nowrap border-r-4 border-r-white rounded-lg text-white ml-4 mt-8 inline-flex items-center justify-center rounded-xl bg-green-600 py-3 px-6 font-dm text-base font-medium text-white shadow-xl shadow-green-400/75 transition-transform duration-200 ease-in-out hover:scale-[1.02]");
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("ContPhone").add(phone);
		RootPanel.get("ContName").add(name);
		RootPanel.get("ContEmail").add(email);
		RootPanel.get("ContMessage").add(message);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		RootPanel.get("senddolar").add(senddolar);
{


{


HTML html = new HTML("<nav class='sticky top-0 h-20 bg-[#800b9a] p-5 sm:px-24 xl:px-64'><div class='mx-auto flex justify-between items-center'><a href='#' class='uppercase text-white text-xl xl:text-3xl font-bold whitespace-no-wrap font-Montserrat leading-normal tracking-tighter'>Start Tailwind</a><button class='block md:hidden uppercase inline-flex items-center bg-green-500 px-3 py-2 rounded-lg text-white'>Menu <svg class='h-4 fill-current' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24'><path d='M4 5h16a1 1 0 0 1 0 2H4a1 1 0 1 1 0-2zm0 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2zm0 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2z'/></svg></button><div class='hidden md:block'><a href='' class='px-4 uppercase text-white text-base font-bold whitespace-no-wrap font-Montserrat leading-normal tracking-tighter hover:text-green-500'>Portfolio</a><a href='' class='px-4 uppercase text-white text-base font-bold whitespace-no-wrap font-Montserrat leading-normal tracking-tighter hover:text-green-500'>About</a><a href='' class='px-4 uppercase text-white text-base font-bold whitespace-no-wrap font-Montserrat leading-normal tracking-tighter hover:text-green-500'>Contact</a></div></div></nav>", true);

VerticalPanel panel = new VerticalPanel();
panel.add(html);
panel.getElement().getStyle().setBackgroundColor("#FFFFFF"); 
RootPanel.get("header").add(html);
RootPanel.get("body").addStyleName("m-0 ");
RootPanel.get("FormPanel").addStyleName("h-screen w-screen bg-black flex justify-center items-center  md:basis-1/3 relative inline-flex items-center justify-center px-8 py-4 text-lg font-bold text-white transition-all duration-200 bg-gray-900 font-pj  focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-900 border-indigo-600 border-color: rgb(251 146 60) 	outline-color: #ecfccb");
RootPanel.get("tilo").addStyleName("text-green-500 ");
RootPanel.get("ContPhone").addStyleName("px-4 py-2 rounded-lg bg-slate-700 focus:bg-slate-800 focus:text-slate-300 text-slate-400 placeholder-slate-400 focus:ring-0 focus:outline-none");
RootPanel.get("ContName").addStyleName("px-4 py-2 rounded-lg bg-slate-700 focus:bg-slate-800 focus:text-slate-300 text-slate-400 placeholder-slate-400 focus:ring-0 focus:outline-none");
RootPanel.get("ContMessage").addStyleName("px-4 py-2 rounded-lg bg-slate-700 focus:bg-slate-800 focus:text-slate-300 text-slate-400 placeholder-slate-400 focus:ring-0 focus:outline-none");
RootPanel.get("ContEmail").addStyleName("px-4 py-2 rounded-lg bg-slate-700 focus:bg-slate-800 focus:text-slate-300 text-slate-400 placeholder-slate-400 focus:ring-0 focus:outline-none");
phone.addStyleName("bg-slate-700 animate-typing overflow-hidden whitespace-nowrap border-r-4 border-r-white pr-5 text-5xl text-white font-bold");
email.addStyleName("bg-slate-700 animate-typing overflow-hidden whitespace-nowrap border-r-4 border-r-white pr-5 text-5xl text-white font-bold");
message.addStyleName("bg-slate-700 animate-typing overflow-hidden whitespace-nowrap border-r-4 border-r-white pr-5 text-5xl text-white font-bold");
name.addStyleName("bg-slate-700 animate-typing overflow-hidden whitespace-nowrap border-r-4 border-r-white pr-5 text-5xl text-white font-bold");
RootPanel.get("exchange").addStyleName("	border-color: rgb(255 255 255) border-width: 4px; w-screen bg-black flex justify-center items-center  md:basis-1/3 relative inline-flex items-center justify-center px-8 py-4  font-bold text-white  duration-200 bg-gray-900  focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-900 border-indigo-600 border-color: rgb(251 146 60) 	outline-color: #ecfccb ");
RootPanel.get("tilo").addStyleName("text-green-500 ");
RootPanel.get("senddolar").addStyleName("bg-slate-700 animate-typing overflow-hidden whitespace-nowrap border-r-4 border-r-white pr-5 text-5xl text-white font-bold px-4 py-2 rounded-lg bg-slate-700 focus:bg-slate-800 focus:text-slate-300 text-slate-400 placeholder-slate-400 focus:ring-0 focus:outline-none");
RootPanel.get("weather").addStyleName(" w-screen bg-black flex justify-center items-center  md:basis-1/3 relative inline-flex items-center justify-center px-8 py-4 text-lg font-bold text-white transition-all duration-200 bg-gray-900 font-pj  focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-900 border-indigo-600 border-color: rgb(251 146 60) 	outline-color: #ecfccb");
RootPanel.get("weatherButton").addStyleName("bg-slate-700 animate-typing overflow-hidden whitespace-nowrap border-r-4 border-r-white pr-5 text-5xl text-white font-bold px-4 py-2 rounded-lg bg-slate-700 focus:bg-slate-800 focus:text-slate-300 text-slate-400 placeholder-slate-400 focus:ring-0 focus:outline-none");


}



}
		// Focus the cursor on the name field when the app loads
		phone.setFocus(true);
		phone.selectAll();
			name.setFocus(true);
		name.selectAll();
			email.setFocus(true);
		email.selectAll();
			message.setFocus(true);
		message.selectAll();


		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);

		dialogBox.addStyleName("w-96 backdrop-blur-lg bg-opacity-80 rounded-lg shadow-lg p-5 bg-gray-900 text-white");
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		closeButton.addStyleName("sendButton bg-green-500 px-2 py-2 verflow-hidden whitespace-nowrap border-r-4 border-r-white rounded-lg text-white ml-4 mt-8 inline-flex items-center justify-center rounded-xl bg-green-600 py-3 px-6 font-dm text-base font-medium text-white shadow-xl shadow-green-400/75 transition-transform duration-200 ease-in-out hover:scale-[1.02]");
		final Label textToServerphoneLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel ");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerphoneLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				// First, we validate the input.
				errorLabel.setText("");
				String textToServerphone = phone.getText();
				if (!FieldVerifier.isValidName(textToServerphone)) {
					errorLabel.setText("Пліз введіть телефон");
					return;
				}
				String textToServername = name.getText();
				if (!FieldVerifier.isValidName(textToServername)) {
					errorLabel.setText("Пліз введіть ваше імя");
					return;
				}
				String textToServeremail = email.getText();
				if (!FieldVerifier.isValidName(textToServeremail)) {
					errorLabel.setText("Пліз ви не ввели пошту");
					return;
				}
				String textToServermessage = message.getText();
				if (!FieldVerifier.isValidName(textToServermessage)) {
					errorLabel.setText("Пліз ви не ввели повідомлення");
					return;
				}

				serverResponseLabel.setText("");
				greetingService.greetServer(textToServername,
						new AsyncCallback<GreetingResponse>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(GreetingResponse result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(new SafeHtmlBuilder()
										.appendEscaped(result.getGreeting())
											.appendHtmlConstant("<br><br>Phone: ")
										.appendHtmlConstant(textToServerphone)
										.appendHtmlConstant("<br><br>Name: ")
										.appendHtmlConstant(textToServername)
										.appendHtmlConstant("<br><br>Email: ")
										.appendHtmlConstant(textToServeremail)
										.appendHtmlConstant("<br><br>Message: ")
										.appendHtmlConstant(textToServermessage)
										
										.appendHtmlConstant(".<br><br>ДЯкуємо що ввели ці дані<br>")
										
										.toSafeHtml());
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		phone.addKeyUpHandler(handler);
	}
}
