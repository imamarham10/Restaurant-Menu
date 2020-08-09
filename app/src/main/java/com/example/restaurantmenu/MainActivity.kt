package com.example.restaurantmenu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
    var adapter:FoodAdapter?=null
    var listOffood = ArrayList<food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load foods
        //1
        listOffood.add(
            food("Coffee",R.drawable.coffee_pot,"Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. When coffee berries turn from green to bright red in color – indicating ripeness – they are picked, processed, and dried.Dried coffee seeds (referred to as \"beans\") are roasted to varying degrees, depending on the desired flavor. Roasted beans are ground and then brewed with near-boiling water to produce the beverage known as coffee.\n" +
                    "\n" +
                    "Coffee is darkly colored, bitter, slightly acidic and has a stimulating effect in humans, primarily due to its caffeine content.It is one of the most popular drinks in the world,and can be prepared and presented in a variety of ways (e.g., espresso, French press, caffè latte). It is usually served hot, although iced coffee is common."))
        //2
        listOffood.add(food("Espresso",R.drawable.espresso,"Espresso is a coffee-making method of Italian origin, in which a small amount of nearly boiling water is forced under pressure (expressed) through finely-ground coffee beans. Espresso coffee can be made with a wide variety of coffee beans and roast levels. Espresso is generally thicker than coffee brewed by other methods, has a higher concentration of suspended and dissolved solids, and has crema on top (a foam with a creamy consistency)." +
                "As a result of the pressurized brewing process, the flavors and chemicals in a typical cup of espresso are very concentrated. The three dispersed phases in espresso are what make this beverage unique. The first dispersed phase is an emulsion of oil droplets. The second phase is suspended solids, while the third is the layer of gas bubbles or foam. The dispersion of very small oil droplets is perceived in the mouth as creamy. This characteristic of espresso contributes to what is known as the body of the beverage. These oil droplets preserve some of the aromatic compounds that are lost to the air in other coffee forms." +
                " This preserves the strong coffee flavor present in the espresso."))
        //3
        listOffood.add(food("French Fries",R.drawable.french_fries,"French fries are served hot, either soft or crispy, and are generally eaten as part of lunch or dinner or by themselves as a snack, and they commonly appear on the menus of diners, fast food restaurants, pubs, and bars. They are usually salted and, depending on the country, may be served with ketchup, vinegar, mayonnaise, tomato sauce, or other local specialties. Fries can be topped more heavily, as in the dishes of poutine or chili cheese fries. Chips can be made from Sweet potato instead of potatoes. A baked variant, oven chips, uses less oil or no oil.French fries are prepared by first cutting the potato (peeled or unpeeled) into even strips, which are then wiped off or soaked in cold water to remove the surface starch, and thoroughly dried.They may then be fried in one or two stages. Chefs generally agree that the two-bath technique produces better results.Potatoes fresh out of the ground can have too high a water content—resulting in soggy fries—so preference is for those that have been stored for a while"))
        //4
        listOffood.add(
            food("Honey",R.drawable.honey,"Honey is a sweet, viscous food substance made by honey bees and some related insects.[1] Bees produce honey from the sugary secretions of plants (floral nectar) or from secretions of other insects (such as honeydew), by regurgitation, enzymatic activity, and water evaporation. Bees store honey in wax structures called honeycombs.[1][2] The variety of honey produced by honey bees (the genus Apis) is the best-known, due to its worldwide commercial production and human consumption.[3] Honey is collected from wild bee colonies, or from hives of domesticated bees, a practice known as beekeeping or apiculture.\n" +
                    "\n" +
                    "Honey gets its sweetness from the monosaccharides fructose and glucose, and has about the same relative sweetness as sucrose (table sugar).It has attractive chemical properties for baking and a distinctive flavor when used as a sweetener.Most microorganisms do not grow in honey, so sealed honey does not spoil, even after thousands of years.")
        )
        //5
        listOffood.add(food("Strawberry Ice cream",R.drawable.strawberry_ice_cream,"Strawberry ice cream is a flavor of ice cream made with strawberry or strawberry flavoring. It is made by blending in fresh strawberries or strawberry flavoring with the eggs, cream, vanilla and sugar used to make ice cream.Most strawberry ice cream is colored pink or light red. Strawberry ice cream dates back at least to 1813, when it was served at the second inauguration of James Madison.Along with vanilla and chocolate ice cream, strawberry is one of the three flavors in Neapolitan ice cream. Variations of strawberry ice cream include strawberry cheesecake ice cream and strawberry ripple ice cream, which is vanilla ice cream with a ribbon of strawberry jam or syrup. Some ice cream sandwiches are prepared neapolitan-style, and include strawberry ice cream."))
        //6
        listOffood.add(food("Sugar Cube",R.drawable.sugar_cubes,"Sugar, shaped in cubes usually measuring about ~4 grams each, often used for coffee or tea. Sugar cubes can be created to look roughly the same size but contain reduced sugar content through a special production process.Additionally, they can contain a blend of acesulfame K and sugar, or a blend of acesulfame K, sugar, and aspartame"))


        //adapter
        adapter = FoodAdapter(this,listOffood)

    }

    inner class FoodAdapter:BaseAdapter{
        var context:Context?=null
        var listoffood = ArrayList<food>()
        constructor(context: Context,listoffood:ArrayList<food>):super()
        {
            this.context = context
            this.listoffood = listoffood
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listoffood[p0]
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflater.inflate(R.layout.food_ticket,null)
            foodView.ivImage.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!
            return foodView

        }

        override fun getItem(p0: Int): Any {
            return listoffood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOffood.size
        }

    }
}