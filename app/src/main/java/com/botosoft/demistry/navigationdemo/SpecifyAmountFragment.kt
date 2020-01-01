package com.botosoft.demistry.navigationdemo


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recepient.*
import kotlinx.android.synthetic.main.fragment_choose_recepient.cancel_btn
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import kotlinx.android.synthetic.main.fragment_specify_amount.view.*
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(),View.OnClickListener {

    private lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments!!.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
        view.recipient.text = "Sending money to $recipient"
    }

    override fun onClick(view: View?) {

        when(view!!.id){
            R.id.send_btn ->

                if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    val amount = Money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf("recipient" to recipient, "amount" to amount)

                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle)
                } else {
                    Toast.makeText(activity, "Please enter an amount", Toast.LENGTH_SHORT).show()
                }

            R.id.cancel_btn -> activity!!.onBackPressed()
        }
    }



}
