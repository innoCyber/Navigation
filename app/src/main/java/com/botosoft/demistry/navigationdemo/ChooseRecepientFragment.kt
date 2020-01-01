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


class ChooseRecepientFragment : Fragment(),View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recepient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        next_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when(view!!.id){
            R.id.next_btn ->

                if (!TextUtils.isEmpty(input_recipient.text.toString())){
                    val bundle = bundleOf("recipient" to input_recipient.text.toString())

                navController.navigate(R.id.action_chooseRecepientFragment_to_specifyAmountFragment,bundle)
                } else{
                    Toast.makeText(activity,"Please enter a recipeint",Toast.LENGTH_SHORT).show()
                }

            R.id.cancel_btn -> activity!!.onBackPressed()
        }
    }


}
